package workshop.collections

import spock.lang.Ignore
import spock.lang.Specification

class CollectionHelperTest extends Specification {

    private CollectionHelper collectionHelper = new CollectionHelper()

    def 'should keep only kiwi'() {
        given:
        List<String> fruits = ["🍊", "🍓", "🍇", "🍉", "🍌", "🍏", "🍅", "🥝", "🥥", "🍑", "🥑"]

        when:
        List<String> fruit = collectionHelper.filterByFruit(fruits, "🥝")

        then:
        fruit.size() == 1
        fruit.first() == "🥝"
    }

    def 'should be exactly as told in method comments'() {
        given:
        List<Integer> numbers = [2, 3, 5, 6, 7, 14, 26]

        when:
        int actual = collectionHelper.exacly(numbers)

        then:
        actual == 96
    }

}
