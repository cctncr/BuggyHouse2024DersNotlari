package s019GenericsObjects;

// ? extends E -> E ve subtype'lari, covariant kullanimi
interface Collection<E> {
    void addAll(Collection<? extends E> items);
}

public class GenericsTest {
    void copyAll(Collection<Object> to, Collection<String> from) {
        to.addAll(from);
    }
}
