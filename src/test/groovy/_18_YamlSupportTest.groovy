import groovy.yaml.YamlBuilder
import groovy.yaml.YamlSlurper
import spock.lang.Specification

class _18_YamlSupportTest extends Specification {

    YamlSlurper ys = new YamlSlurper()

    def "should get properties from yaml configuration"() {
        given:
        def inputString = '''
title: "Example yaml config"
server:
  host: "127.0.0.1"
  port: 8080

app:
  name: "MyApp"
  debug: true
  log_level: info'''.trim()

        when:
        def yaml = ys.parseText(inputString)

        then:
        yaml.title == "Example yaml config"
        yaml.server.host == "127.0.0.1"
        yaml.app.name == "MyApp"
    }

    def "Should be able to create yaml file using builder"() {
        def builder = new YamlBuilder()
        builder {
            title 'Created config'
            server {
                host "127.0.0.1"
                port 8080
            }
        }
        def yaml = ys.parseText(builder.toString())

        expect:
        yaml.server.host == "127.0.0.1"
    }

}
