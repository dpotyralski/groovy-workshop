import groovy.sql.Sql
import spock.lang.Specification

class _22_GroovySqlTest extends Specification {

    static Sql sql = Sql.newInstance("jdbc:h2:./data/test", "sa", 'sa', "org.h2.Driver")

    void setupSpec() {
        sql.execute('''
drop table if exists customers;
create table customers(id varchar, name varchar);
insert into customers (id, name) values ('1006e3f5-fa3d-48a7-833d-2b7df58b7b46', 'tom');
insert into customers (id, name) values ('bc299f40-69a8-4d9c-bcb5-2b0660b21085', 'ben');
''')
    }

    def "Should show how to use sql groovy helper"() {
        def rows = sql.rows("select * from customers")

        expect:
        !rows.isEmpty()
    }
    def "Should get the first row"() {
        def firstOne = sql.firstRow("select * from customers")

        expect:
        firstOne.name == "tom"
    }

    def "Should show how to use sql groovy helper"() {
        Sql.withInstance("jdbc:h2:./data/test", "sa", 'sa', "org.h2.Driver") {
            sql ->
                sql.eachRow("select name from customers") { row ->
                    println row
                }
        }

        expect:
        true
    }

    void cleanupSpec() {
        sql.close()
    }
}
