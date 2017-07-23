/**
 * Created by himalayj on 7/23/17.
 */

// Optional brackets
def x = 1
assert x == 1

assert ('text' * 3 << 'hello').size() == 4 * 3 + 5

class Book {
    private String title
    Book (String theTitle) {
        title = theTitle
    }
    String getTitle(){
        return title
    }
}

Book gina = new Book('Groovy in Action')
assert gina.getTitle() == 'Groovy in Action'
assert getTitleBackwards(gina) == 'noitcA ni yvoorG'
String getTitleBackwards(book) {
    String title = book.getTitle()
    return title.reverse()
}

import groovy.transform.Immutable
@Immutable class FixedBook {
    String title
}

def gina1   = new FixedBook('Groovy in Action')
def regina = new FixedBook(title:'Groovy in Action')
assert gina1.title == 'Groovy in Action'
assert gina1 == regina
try {
    gina1.title = "Oops!"
    assert false, "should not reach here"
} catch (ReadOnlyPropertyException expected) {
    println "Expected Error: '$expected.message'"
}

//@Grab('commons-lang:commons-lang:2.4')
//import org.apache.commons.lang.ClassUtils
//class Outer {
//    class Inner {}
//}
//assert !ClassUtils.isInnerClass(Outer)
//assert ClassUtils.isInnerClass(Outer.Inner)

def nick = 'ReGina'
def book = 'Groovy in Action, 2nd ed.'
assert "$nick is $book" == 'ReGina is Groovy in Action, 2nd ed.'

def xx = 1
def y = 2
assert xx + y == 3
assert xx.plus(y) == 3
assert xx instanceof Integer

def roman = ['', 'I', 'II', 'III', 'IV', 'V', 'VI', 'VII']
assert roman[4] == 'IV'
roman[8] = 'VIII'
assert roman.size() == 9


def http = [
        100 : 'CONTINUE',
        200 : 'OK',
        400 : 'BAD REQUEST'
]
assert http[200] == 'OK'
http[500] = 'INTERNAL SERVER ERROR'
assert http.size() == 4

def xxx = 1..10
assert xxx.contains(5)
assert !xxx.contains(15)
assert xxx.size() == 10
assert xxx.from == 1
assert xxx.to == 10
assert xxx.reverse() == 10..1

assert [ a: 1, b: 1 ] << [ a: 0 ] == [ a: 0, b: 1 ]

def totalClinks = 0
1.upto(100) {
    guestNumber ->
        totalClinks += guestNumber-1
}

println(totalClinks)

//It’s not the dynamic typing that makes a dynamic language dynamic. It’s the dynamic method dispatch.
// getMetaClass().invokeMethod(this, "foo", EMPTY_PARAMS_ARRAY)
// @CompileStatic no longer calls getMetaClass. Thus getting performance boost.