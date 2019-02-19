<template>
    <div class="home">
        <el-container>
            <el-header>Header</el-header>
            <el-container>
                <el-aside width="200px">
                    <router-link to="/home/userlist">userlist</router-link><br/>
                    <router-link to="/home/rolelist">rolelist</router-link><br/>
                    <router-link to="/home">home</router-link><br/>
                </el-aside>
                <el-main>
                    <router-view></router-view>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>
