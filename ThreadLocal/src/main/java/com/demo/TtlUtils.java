package com.demo;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * description:多线程下处理ThreadLocal
 *
 * @author 刘一博
 * @version V1.0
 * @date 2020/6/12 17:51
 */
public class TtlUtils {

    private static final TransmittableThreadLocal<Map<String, Object>> THREAD_LOCAL = new TransmittableThreadLocal<>();

    private static final ExecutorService executorService = TtlExecutors.getTtlExecutorService(new ThreadPoolExecutor(100, 200,
            3600, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5000), r -> {
        Thread thread = new Thread(r);
        thread.setName("recall-ttl-pool");
        return thread;
    }));

    public static Future<?> submit(Runnable runnable) {
        return executorService.submit(runnable);
    }

    public static void execute(Runnable runnable) {
        executorService.execute(runnable);
    }

    public static void setContext(String name, Object value) {
        Map<String, Object> map = THREAD_LOCAL.get();
        if (map == null) {
            map = new HashMap<>(16);
            THREAD_LOCAL.set(map);
        }
        map.put(name, value);
    }

    public static <T> T getContext(String name) {
        Map<String, Object> map = THREAD_LOCAL.get();
        if (map == null) {
            return null;
        }
        return (T) map.get(name);
    }

    public static void destroy() {
        THREAD_LOCAL.remove();
    }

}
