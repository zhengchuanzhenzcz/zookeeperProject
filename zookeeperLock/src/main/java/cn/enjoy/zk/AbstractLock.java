package cn.enjoy.zk;

/**
 * Created by VULCAN on 2018/9/29.
 */
public abstract class AbstractLock implements Lock {

    public void getLock() {
        //尝试获得锁资源
        if (tryLock()) {
            System.out.println("##获取lock锁的资源####");
        } else {
            // 等待
            waitLock();
            // 重新获取锁资源
            getLock();
        }

    }

    // 获取锁资源
    public abstract boolean tryLock();

    // 等待
    public abstract void waitLock();
}
