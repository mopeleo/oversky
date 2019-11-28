package org.oversky.util.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.oversky.util.date.DateUtils;
import org.oversky.util.exception.BaseUtilException;

public class FTPTools {
	
	private FTPClient ftpClient;
	
	public FTPTools(String userName, String password, String host, int port) {
		this.login(userName, password, host, port);
	}

    public void login(String userName, String password, String host, int port) {
    	if(ftpClient == null) {
        	ftpClient = new FTPClient();
    	}else {
    		this.close();
    	}
    	
    	try {
	    	ftpClient.connect(host, port);
	    	boolean isLogin = ftpClient.login(userName, password);
			if (!isLogin) {
				throw new BaseUtilException("登录ftp服务失败！");
			}
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftpClient.setControlEncoding("UTF-8");
			ftpClient.enterLocalPassiveMode();
    	}catch(Exception e) {
    		e.printStackTrace();
    		throw new BaseUtilException("ftp连接失败:" + e.getMessage());
    	}
    }

    public void putFile(String remoteDir, String remotefileName, String localFileName){
        InputStream inputStream = null;
        try{
            inputStream = new FileInputStream(new File(localFileName));
            this.createRemoteDirecroty(remoteDir);
            ftpClient.changeWorkingDirectory(remoteDir);
            ftpClient.storeFile(remotefileName, inputStream);
            inputStream.close();
            this.changeInitDirecroty();
        }catch (Exception e) {
            e.printStackTrace();
    		throw new BaseUtilException("ftp上传文件失败:" + e.getMessage());
        }finally{
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            } 
        }
    }
    
    public void getFile(String remoteDir, String remotefileName, String localDir){
    	OutputStream outputStream = null;
        try { 
            //文件下载前，FTPClient工作目录必须切换到文件所在的目录，否则下载失败
            if(!ftpClient.changeWorkingDirectory(remoteDir)) {
        		throw new BaseUtilException("远程目录[" + remoteDir + "]不存在");
            }

			InputStream inputStream = ftpClient.retrieveFileStream(remotefileName);
	        if (inputStream == null || ftpClient.getReplyCode() == FTPReply.FILE_UNAVAILABLE) {
	        	throw new RuntimeException("文件[" + remotefileName + "]不存在");
	        }
	        
	        if (inputStream != null) {
	            inputStream.close();
	            ftpClient.completePendingCommand(); // 必须执行，否则在循环检查多个文件时会出错
	        }

	        File localFile = new File(localDir + "/" + remotefileName); 
            outputStream = new FileOutputStream(localFile); 
            ftpClient.retrieveFile(remotefileName, outputStream); 
            outputStream.close();
            this.changeInitDirecroty();
        } catch (Exception e) { 
            e.printStackTrace();
    		throw new BaseUtilException("ftp下载文件失败:" + e.getMessage());
        } finally{ 
            if(outputStream != null){
                try {
                	outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            } 
        } 
    }
    
    public int getDirecroty(String remoteDir, String localDir){
    	OutputStream outputStream = null;
    	int fileNum = 0;
        try { 
            //切换FTP目录 
            if(!ftpClient.changeWorkingDirectory(remoteDir)) {
        		throw new BaseUtilException("远程目录[" + remoteDir + "]不存在");
            }
            FTPFile[] ftpFiles = ftpClient.listFiles(); 
            for(FTPFile file : ftpFiles){ 
                File localFile = new File(localDir + "/" + file.getName()); 
                outputStream = new FileOutputStream(localFile); 
                ftpClient.retrieveFile(file.getName(), outputStream); 
                outputStream.close(); 
            }
            this.changeInitDirecroty();
            fileNum = ftpFiles.length;
        } catch (Exception e) { 
            e.printStackTrace(); 
    		throw new BaseUtilException("ftp下载文件夹失败:" + e.getMessage());
        } finally{ 
            if(outputStream != null){
                try {
                	outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            } 
        } 
        return fileNum;
    }

    public void deleteFile(String remoteDir, String fileName){ 
        try { 
            //切换FTP目录 
            if(!ftpClient.changeWorkingDirectory(remoteDir)) {
        		throw new BaseUtilException("远程目录[" + remoteDir + "]不存在");
            }
            ftpClient.deleteFile(fileName); 
            this.changeInitDirecroty();
        } catch (IOException e) { 
            e.printStackTrace(); 
    		throw new BaseUtilException("ftp删除文件失败:" + e.getMessage());
        }
    }
    
    public void close() {
		if (ftpClient.isConnected()) {
			try {
				// 退出登录状态
				ftpClient.logout();
				// 销毁连接
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    }
    
    private void createRemoteDirecroty(String remoteDir) throws IOException{
        String directory = remoteDir + "/";
        // 如果远程目录不存在，则递归创建远程服务器目录
        if (!directory.equalsIgnoreCase("/") && !ftpClient.changeWorkingDirectory(directory)) {
            int start = 0;
            int end = 0;
            if (directory.startsWith("/")) {
                start = 1;
            } else {
                start = 0;
            }
            end = directory.indexOf("/", start);
            while (true) {
                String subDirectory = new String(remoteDir.substring(start, end).getBytes("UTF-8"), "ISO-8859-1");
                if (!ftpClient.changeWorkingDirectory(subDirectory)) {
                    if (ftpClient.makeDirectory(subDirectory)) {
                    	ftpClient.changeWorkingDirectory(subDirectory);
                    } else {
                    	throw new BaseUtilException("远程创建目录[" + subDirectory + "]失败！");
                    }
                }

                start = end + 1;
                end = directory.indexOf("/", start);
                // 检查所有目录是否创建完毕
                if (end <= start) {
                	this.changeInitDirecroty();
                    break;
                }
            }
        }
    }

    private void changeInitDirecroty() throws IOException {
    	ftpClient.changeWorkingDirectory("/");
    }
    
    public static void main(String[] args) {
		String username= "fms";
		String password= "fms";
		String host="192.168.1.236";
		int port=21;
		
		FTPTools ftp = new FTPTools(username, password, host, port);
//		ftp.putFile("deps/ftptest/" + DateUtils.getNowDate(), "test.zip", "d:/SWP02_02报告.zip");
		ftp.deleteFile("deps/ftptest/" + DateUtils.getNowDate(), "test.zip");
		ftp.getFile("deps/ftptest/" + DateUtils.getNowDate(), "test.txt", "d:/");
		ftp.getDirecroty("deps/ftptest/" + DateUtils.getNowDate(),  "d:/test");
		ftp.close();
	}
}
