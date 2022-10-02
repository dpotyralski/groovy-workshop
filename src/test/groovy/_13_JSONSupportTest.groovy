import groovy.json.JsonGenerator
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import spock.lang.Specification

class _13_JSONSupportTest extends Specification {

    JsonSlurper jsonSlurper = new JsonSlurper()

    def "should convert JSON to map"() {
        given:
        String jsonInput = '{ "name": "John Doe" } /* some comment */'

        when:
        Object map = jsonSlurper.parseText(jsonInput)

        then:
        map instanceof Map
        map.name == 'John Doe'
        map['name'] == 'John Doe'
    }

    def "should support JSON array parsing"() {
        given:
        String json = '''{ "myList": [4, 8, 15, 16, 23, 42] }'''

        when:
        def object = jsonSlurper.parseText(json)

        then:
        object instanceof Map
        object.myList instanceof List
        object.myList == [4, 8, 15, 16, 23, 42]
    }

    def "should support JSON parsing to class"() {
        given:
        String jsonInput = '''
                            {
                              "priority": 2,
                              "issue": {
                                "id": "c06249b1-9d3f-415f-8d9b-1c7b7d1e31dd",
                                "description": "Some description"
                              }
                            }
                            '''

        when:
        Item item = jsonSlurper.parseText(jsonInput) as Item

        then:
        item instanceof Item

        with(item) {
            priority == 2
            with(issue) {
                id == "c06249b1-9d3f-415f-8d9b-1c7b7d1e31dd"
                description == "Some description"
            }
        }
    }

    def "should transform map to a valid json"() {
        given:
        Map map = [issue: 1, topic: "Fix error"]

        when:
        String json = JsonOutput.toJson(map)

        then:
        json == '{"issue":1,"topic":"Fix error"}'
    }

    def "should transform list of objects to a valid json"() {
        when:
        String json = JsonOutput.toJson([
                new Item(priority: 1, issue: new Item.Issue(id: "f2aca549-dad6-4f71-b3cf-45eba1ed2a70", description: "Est camerarius adgium, cesaris.")),
                new Item(priority: 3, issue: new Item.Issue(id: "a477f9ff-30c1-40f8-9373-0ecba6f1427e", description: "Est dexter axona, cesaris."))
        ])

        then:
        JsonOutput.prettyPrint(json) == '''\
[
    {
        "priority": 1,
        "issue": {
            "id": "f2aca549-dad6-4f71-b3cf-45eba1ed2a70",
            "description": "Est camerarius adgium, cesaris."
        }
    },
    {
        "priority": 3,
        "issue": {
            "id": "a477f9ff-30c1-40f8-9373-0ecba6f1427e",
            "description": "Est dexter axona, cesaris."
        }
    }
]'''.stripIndent()
    }

    def "should be able to customize the output"() {
        given:
        JsonGenerator build = new JsonGenerator.Options()
                .excludeNulls()
                .excludeFieldsByName("priority")
                .build()

        and:
        Item item = new Item(priority: 2, issue: new Item.Issue(id: null, description: "Est camerarius adgium, cesaris."))

        expect:
        build.toJson(item) == "{\"issue\":{\"description\":\"Est camerarius adgium, cesaris.\"}}"
    }

    static class Item {
        int priority
        Issue issue

        static class Issue {
            String id
            String description
        }
    }

}