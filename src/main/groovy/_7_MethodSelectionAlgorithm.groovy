class MethodSelectionAlgorithm {

    def method(Object o1, Object o2) { 'o/o' }

    def method(Integer i, String  s) { 'i/s' }

    def method(String  s, Integer i) { 's/i' }

    def method(I1 i1) { 'I1' }

    def method(I3 i3) { 'I3' }

    def method(String s) { 'non-vararg' }

    def method(String s, Object... vargs) { 'vararg' }

    def method(String s, Integer i, Object... vargs) { 'one varg' }

    def method(Base b) { 'superclass' }

    def method(Byte b) { 'Byte' }

    def method(Short s) { 'Short' }

    def method(Long l) { 'Long' }

    def method(Date d, Object o) { 'd/o' }

    def method(Object o, String s) { 'o/s' }

}

interface I1 {}
interface I2 extends I1 {}
interface I3 {}

class Clazz implements I3, I2 {}

class Base {}
class Child extends Base implements I1 {}





