package question_2;

// 静态内部类-懒汉式
public class StaticLazySingleton {
    private static class InstanceHolder {
        private static final StaticLazySingleton INSTANCE = new StaticLazySingleton();
    }

    private StaticLazySingleton() {
    }

    public static StaticLazySingleton getInstance() {
        return InstanceHolder.INSTANCE;
    }
}
