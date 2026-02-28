import java.util.HashMap;
import java.util.Map;

public class ObjectRegistry {
    /*
    * Why do we need this registry?
    * - We could have made our Services or Repositories class Singleton but that is not how
    *   Spring Boot works.
    * - Because, in a standard Spring Boot application, there is only one object shared
    *   across all running threads. We are trying to simulate that behavior here.
    * - In Spring terminology, these objects (Services, Repositories, etc.) are called Beans.
    *   By default, their "scope" is a Singleton.
    * - One Object: When the application starts, Spring creates one instance of our Service.
    * - Many Threads: When multiple users hit our website at the same time, the server spawns
    *   multiple threads. Every single one of those threads points back to that same, single
    *   instance of the Service.
    * - Why doesn't it crash? (The "Stateless" Rule): We might wonder that "If 50 threads are using
    *   one object, won't they overwrite each other's data?"
    *   They won't, as long as our Service is stateless.
    *       1. Local Variables: Variables defined inside a method are stored on the Thread Stack.
    *          They are private to that thread.
    *       2. Instance Variables: If we define a variable at the top of the class (outside a method),
    *          all threads share it.
    *     Crucial Rule: Never store user-specific data in a field of a Spring Service or Repository.
    *     Since there is only one object, User A’s data would overwrite User B’s data.
    * - Is it ever "One per Thread": Spring does have a "Request Scope" (one object per HTTP request)
    *   and a "Prototype Scope" (a new object every time we ask for one), but these are rarely used
    *   for Services or Repositories. Using a Singleton is much more efficient because it saves memory
    *   and reduces the "garbage collection" overhead of constantly creating and destroying objects.
    * */
    private static Map<String, Object> objects = new HashMap<>();
    public static void put(String name, Object object) {
        objects.put(name, object);
    }

    public static Object get(String name) {
        return objects.get(name);
    }
}
