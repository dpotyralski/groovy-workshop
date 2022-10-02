import spock.lang.Specification

class _11_CollectionsTest extends Specification {

    def "should successfully declare a list"() {
        given:
        List<Integer> integers = [1, 2, 3, 4, 5]

        expect:
        integers instanceof LinkedList
        integers.size() == 5
    }

    def "should be able to declare heterogeneous list"() {
        given:
        ArrayList<Serializable> list = [1, 'test', false]

        when:
        ArrayList<Serializable> updated = list*.toString()

        then:
        updated == ['1', 'test', 'false']
    }

    def "should multiply by 2 each element from the list with `spread` operator"() {
        given:
        List<Integer> integers = [1, 2, 3, 4, 5]

        when:
        ArrayList<Integer> updated = integers*.multiply(2) //Spread Operator

        then:
        integers instanceof ArrayList
        updated == [2, 4, 6, 8, 10]
    }

    def "should multiply by 2 each element from the list with `collect` method"() {
        given:
        List<Integer> integers = [1, 2, 3, 4, 5]

        when:
        ArrayList<Integer> updated = integers.collect { it * 2 } // aka map

        then:
        integers instanceof ArrayList
        updated == [2, 4, 6, 8, 10]
    }

    def "should multiply by 2 each element from the list with `each` method"() {
        given:
        List<Integer> integers = [1, 2, 3, 4, 5]
        List<Integer> output = new ArrayList<>()

        when:
        integers.each({ output.add(it * 2) })

        then:
        output == [2, 4, 6, 8, 10]
    }

    def "should find first entry in collection "() {
        given:
        List<String> list = ['a', 'b', 'c', 'd']

        when:
        String result = list.find { it == 'b' }

        then:
        result == 'b'
    }

    def "should get null when element not found collection "() {
        given:
        List<String> list = ['a', 'b', 'c', 'd']

        when:
        String result = list.find { it == 'x' }

        then:
        result == null
    }

    def "should check that element is in collection using `in` operator"() {
        given:
        List<Serializable> list = [1, 'test', false] as List //different backing type for our lists

        expect:
        list instanceof LinkedList
        'test' in list
    }

    def "should find all entries matching in the collection "() {
        given:
        List<Integer> list = [1, 2, 3, 4, 5, 6]

        when:
        List<Integer> result = list.findAll { it > 3 } // aka filter

        then:
        result == [4, 5, 6]
    }

    def "should give an example for map/filter/reduce on the collection"() {
        given:
        List<Integer> list = [1, 2, 3, 4, 5, 6]

        when:
        int result = list
                .findAll { it > 3 } // aka filter
                .collect { it * 2 }
                .inject { accumulator, value -> accumulator + value }

        then:
        result == 30
    }

    def "should give an example for map/filter/reduce in the collection using Java8 stream"() {
        given:
        List<Integer> list = [1, 2, 3, 4, 5, 6]

        when:
        int result = list.stream()
                .filter { it > 3 } // aka filter
                .map { it * 2 }
                .reduce { accumulator, value -> accumulator + value }
                .get()

        then:
        result == 30
    }

    def "should get element from the list using [] subscript operator"() {
        given:
        List<Serializable> list = [1, 'test', false]

        expect: "to take second element from the list"
        list[1] == 'test'

        and: "take second and third element"
        list[1..2] == ['test', false]
    }

    def "should declare an array and sum values"() {
        given:
        String[] arrayOfStrings = ['Ananas', 'Banana', 'Kiwi']
        Integer[] arrayOfIntegers = [1, 2, 3]
        String[] javaWayOfDeclaration = new String[]{'A', 'B', 'C'}

        expect:
        arrayOfStrings.sum() == 'AnanasBananaKiwi'
        arrayOfIntegers.sum() == 6
        javaWayOfDeclaration.sum() == 'ABC'
    }

    def "should successfully declare a set"() {
        given:
        HashSet<Serializable> set = [false, 'false', 2] as HashSet

        expect:
        set instanceof HashSet
        set.size() == 3
    }

    def "should get element from the map using [] subscript operator"() {
        given:
        Map<String, String> map = [red: '#FF0000', green: '#00FF00', blue: '#0000FF']

        expect:
        map['blue'] == '#0000FF'
        map.blue == '#0000FF'
    }

    def "should get element from the map using property notation"() {
        given:
        def map = [red: '#FF0000', green: '#00FF00', blue: '#0000FF']

        expect:
        map.green == '#00FF00'
    }

    def "should get null when element has not been found in given map"() {
        given:
        LinkedHashMap<String, String> map = [red: '#FF0000', green: '#00FF00', blue: '#0000FF']

        expect:
        map.yellow == null

        and:
        map['yellow'] == null
    }

    def "should combine lists"() {
        given:
        List<String> listA = ['a']
        List<String> listB = ['b']

        expect:
        listA + listB == ['a', 'b']
    }

    def "should deduct lists"() {
        given:
        List<String> listA = ['a', 'b']
        List<String> listB = ['b']

        expect:
        listA - listB == ['a']
    }

    def "Empty map"() {
        given:
        def map = [:]

        expect:
        map.isEmpty()
    }

    def "addition"() {
        given:
        LinkedHashMap<String, String> map = [red: '#FF0000']

        expect:
        map + [blue: '#0000FF'] == [red: '#FF0000', blue: '#0000FF']
        map.plus([blue: '#0000FF']) == [red: '#FF0000', blue: '#0000FF']
    }

    def "subtract"() {
        given:
        LinkedHashMap<String, String> map = [red: '#FF0000', green: '#00FF00', blue: '#0000FF']
        LinkedHashMap<String, String> secondMap = [red: '#FF0000']

        expect:
        map - secondMap == [green: '#00FF00', blue: '#0000FF']
        map - secondMap == [green: '#00FF00', blue: '#0000FF']
    }

    def "sorting"() {
        given:
        LinkedHashMap<String, String> map = [red: '#FF0000', green: '#00FF00', blue: '#0000FF']

        expect:
        map.sort() == [blue: '#0000FF', green: '#00FF00', red: '#FF0000']
        map.sort(false)
    }

    def "should use range as a source of numbers"() {
        expect:
        (2..12).findAll { it % 2 == 0 && it < 8 } == [2, 4, 6]
    }

    def "should use Java8 method reference"() {
        expect:
        (1..3).stream().map(String::valueOf).toList() == ['1', '2', '3']
    }

    def "should use characters"() {
        expect:
        ('a'..'d').collect() == ['a', 'b', 'c', 'd']
    }

}
