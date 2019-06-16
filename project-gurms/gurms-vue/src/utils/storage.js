/**
 *  本地存储对象
 */
export default {
    // 存储一个值，k 为key，v 为字符串格式的值
    set(k, v) {
        localStorage.setItem(k, v);
    },
    // 获取一个值，k 为之前保存的key
    get(k) {
        return localStorage.getItem(k);
    },
    // 移除一个值，k 为之前保存的key
    remove(k) {
        localStorage.removeItem(k);
    },
    clear() {
        localStorage.clear();
    }
};
