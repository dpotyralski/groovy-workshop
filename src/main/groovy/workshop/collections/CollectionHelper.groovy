package workshop.collections

class CollectionHelper {

    List<String> filterByFruit(List<String> fruits, String filterFruit) {
        return fruits.findAll { it == filterFruit }
    }

    Integer exacly(List<Integer> integers) {
        return integers
                .findAll { it % 2 == 0 }
                .collect { it * 2 }
                .sum()
    }


}
