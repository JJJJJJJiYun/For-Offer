package question_2;

// 双重检测-懒汉式
public class DoubleCheckLazySingleton {
    private volatile static DoubleCheckLazySingleton instance;

    private DoubleCheckLazySingleton() {
    }

    public static DoubleCheckLazySingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLazySingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckLazySingleton();
                }
            }
        }
        return instance;
    }
}
