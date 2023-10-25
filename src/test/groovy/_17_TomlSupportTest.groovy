import groovy.toml.TomlBuilder
import groovy.toml.TomlSlurper
import spock.lang.Specification

class _17_TomlSupportTest extends Specification {

    private TomlSlurper ts = new TomlSlurper()

    def "should get properties from toml configuration"() {
        def toml = ts.parseText '''
                title = "Example toml config"
                [server]
                host = "127.0.0.1"
                port = 8080
                
                [app]
                name = "MyApp"
                debug = true
                log_level = "info"
                '''.trim()

        expect:
        toml.title == "Example toml config"
        toml.server.host == "127.0.0.1"
        toml.app.name == "MyApp"
    }

    def "Should be able to create toml file using builder"() {
        def builder = new TomlBuilder()
        builder {
            title 'Created config'
            server {
                host "127.0.0.1"
                port 8080
            }
        }
        def toml = ts.parseText(builder.toString())

        expect:
        toml.server.host == "127.0.0.1"
    }

}
