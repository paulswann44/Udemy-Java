package ImmutableClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Example {
    // 1. Make all fields final and private.
    private final String name;
    private final int age;
    private final List<String> interests;

    // 2. Don't allow subclasses to override methods
    // 2a. The simplest way to do this is to declare the class as final
    private Example(String name, int age, List<String> interests) {
        this.name = name;
        this.age = age;
        this.interests = new ArrayList<>(interests);
    }

    // 2b. A more sophisticated approach is to make the constructor private
    // and construct instances in factory methods.
    public static Example createPerson(String name, int age, List<String> interests) {
        return new Example(name, age, interests);
    }

    // Getter methods for the name, age and interests fields
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getInterests() {
        // 4. Never store references to external, mutable objects passed to the constructor
        // Return a copy of the internal mutable list to avoid returning the original
        return Collections.unmodifiableList(new ArrayList<>(interests));
    }

    // 1. Don't provide "setter" methods
    // No setter methods for the name, age or interests fields - they are immutable
    // and cannot be changed once the Person object is constructed

    // 3. Don't share references to the mutable objects
    // The interests field is a reference to a mutable object, but it is only accessible
    // through the getInterests() method which returns a copy of the list to avoid sharing
    // references to the mutable object.
}

/*
1. Don't provide "setter" methods — methods that modify fields or objects referred to by fields. ✅

2. Make all fields final and private.  ✅


3. Don't allow subclasses to override methods. ✅
    a. The simplest way to do this is to declare the class as final.✅
    b. A more sophisticated approach is to make the constructor private 🚫
    and construct instances in factory methods. ✅
    EXAMPLE:
            "this.exits = new HashMap<String, Integer>(exits);"

    c. If the instance fields include references to mutable objects, don't allow those objects to be changed:
    Don't provide methods that modify the mutable objects.

4. Don't share references to the mutable objects. Never store references to external, mutable objects passed to the constructor;
if necessary, create copies, and store references to the copies.
Similarly, create copies of your internal mutable objects when necessary to avoid returning the originals in your methods
* */
