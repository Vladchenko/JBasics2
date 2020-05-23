/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.java.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * http://docs.oracle.com/javase/6/docs/api/java/util/regex/Pattern.html
 *
 * http://callumacrae.github.io/regex-tuesday/ - regexes tasks with tests.
 *
 * [^;] matches any character except ;
     + is a quantifier that matches preceding char or group 1 to many times
     * is a quantifier that matches preceding char or group 0 to many times
     $ is the end of the string
     (?=pattern) is a lookahead which checks if a particular pattern occures ahead
 *
 * @author Vlad
 */
public class RegularExpressions {

    public RegularExpressions() {
//        testing2();
        testing();
//        System.out.println(removeSpecialChars(
//                "This - text ! has \\ /allot # of % special % characters")
//        );
    }

    public void testing() {

        // String to be scanned to find the pattern.
//        String line = "This order was placed for QT3000! OK?";
        String line = "1 2 3 34 56 789 9u0 123456789";

        /**
         * Following pattern illustrates how to find a digit
         * string from the given alphanumeric string.
         */
        //String pattern = "(.*)(\\d+)(.*)";
        //String pattern = "(\\d+)(.*)";
        //String pattern = "(.*)(\\d+)";
//        String pattern = "(\\d+)";
        String pattern = "[0-9]+";

        // Create a Pattern object
        Pattern p = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = p.matcher(line);
        System.out.println("Total number of groups: " + m.groupCount());
        if (m.find()) {
            int groupCount = m.groupCount();
            for (int i = 0; i < groupCount; i++) {
                System.out.println("Group: " + m.group(i) + ", start="
                        + m.start() + ", end=" + m.end());
            }
        } else {
            System.out.println("No match");
        }

        // + - one or more letters
//        System.out.println("1".matches("\\d"));  // true (one digit)
//        System.out.println("12".matches("\\d"));  // false (one digit)
//        System.out.println("123".matches("\\d+"));  // true (one or more digits)
//        System.out.println("123 ".matches("\\d+"));  // false
//        System.out.println("qwe".matches("\\w+"));  // true (one or more letters)
//
//        // | - or
//        System.out.println("1".matches("\\d|\\w"));  // true
//        System.out.println("q".matches("\\d|\\w"));  // true
//        System.out.println("1q".matches("\\d|\\w"));  // false
//
//        // \\s - all whitespace letters, [ \t\n\x0B\f\r]
//        System.out.println("qwe123".matches("\\w+\\d+"));  // true
//        System.out.println("123qwe456".matches("\\w+\\d+"));  // true
//        System.out.println(" 123qwe456".matches("\\w+\\d+"));  // false
//        System.out.println(" 123qwe456".matches("\\s\\w+\\d+"));  // true
//        System.out.println(" 123qwe456".matches(" \\w+\\d+"));  // true
//
//        System.out.println("a".matches("[a-z]"));  // true (only one letter)
//        System.out.println("ab".matches("[a-z]+"));  // true (one or more letters)
//        System.out.println("abcdmnop".matches("[a-z]+[m-p]+"));  // true (one or more letters)
//        System.out.println("eeioeiu".matches("[aeiou]+"));  // true (matching all vowels)
//
//        // ^ - negation
//        System.out.println("abcdmnop".matches("[a-z&&[^bc]]+"));  // false
//        System.out.println("admnop".matches("[a-z&&[^bc]]+"));  // true
//
//        // {n} - how many times repeated
//        System.out.println("111".matches("[1]{3}"));  // true
//        System.out.println("1111".matches("[1]{3}"));  // false
//
//        // {n,} - at least n times
//        System.out.println("111".matches("[1]{3,}"));  // true
//        System.out.println("1111".matches("[1]{3,}"));  // true


        System.out.println("9048678821".matches("[0-9]{10}"));  // true
        System.out.println("904-867-88-21".matches("[0-9]{3}[-]{1}[0-9]{3}[-]{1}[0-9]{2}[-]{1}[0-9]{2}"));  // true
        // Phone number may have or might not have + in the beginning.
        // Then it may have a country code, having 1 to 3 digits in it.
        // Then it should have 3 digits - 3 digits - 2 digits - 2 digits
        // ? - once or not at all
        String phoneNumberPatter = "([+]?[0-9]{1,3}[-]{1})?[0-9]{3}[-]{1}[0-9]{3}[-]{1}[0-9]{2}[-]{1}[0-9]{2}";
        System.out.println("+7-904-867-88-21".matches(phoneNumberPatter));  // true
        System.out.println("904-867-88-21".matches(phoneNumberPatter));  // true
        System.out.println("-904-867-88-21".matches(phoneNumberPatter));  // false
        System.out.println("7-904-867-88-21".matches(phoneNumberPatter));  // true
        System.out.println("7904-867-88-21".matches(phoneNumberPatter));  // false
        System.out.println("-7-904-867-88-21".matches(phoneNumberPatter));  // false

        System.out.println("qwertyuiop".matches("[a-z]+?"));  // false

    }

    public void testing2() {

        final Pattern pattern = Pattern.compile("[a-zA-Z]{1}[a-zA-Z\\d\\u002E\\u005F]+@([a-zA-Z]+\\u002E){1,2}((net)|(com)|(org))");

        String word = "c0nst@money.simply.net";
//        String word = "somebody@dev.com.ua";
//        String word = "Name.Sur_name@gmail.com";
//        String word = "useR33@somewhere.in.the.net";

        String output = "Validation for \"" + word + "\"";
        Matcher matcher = pattern.matcher(word);
        if (matcher.matches()) {
            output += " passed.";
        } else {
            output += " not passed.";
        }
        System.out.println(output);

    }

    public void testing3() {

//        https://regexone.com/

//        Match	abcdefg	Success
//        Match	abcde	Success
//        Match	abc	Success
//        \w+   or  \D+ or  [a-z]+  or \w{3,7}  or \S+

//        Match	abc123xyz	    Success
//        Match	define "123"	Success
//        Match	var g = 123;	Success
//        ([a-z]+[ ]?)+([=][ ])?["]?\d+["]?([a-z]+)?[;]?    or  (\w+\s?)+(=\s)?"?(\d+)?"?;?

//        Match	cat.	Success
//        Match	896.	Success
//        Match	?=+.	Success
//        ([a-z]+)?([\d]+)?([\\?=\\+\\.])?[^abc1]   or  (\w+)?(\?=\+)?\.?[^abc1]
//              or  (...)[^abc1]    or  .+[^abc1]

//        Match	can	    Success
//        Match	man	    Success
//        Match	fan	    Success
//        Skip	dan	    To be completed
//        Skip	ran	    To be completed
//        Skip	pan	    To be completed
//        [cmf]an      or  [^drp]an

//        Match	hog	    Success
//        Match	dog	    Success
//        Skip	bog	    To be completed
//        [hd]og    or  [^b]og

//        Match	Ana	    Success
//        Match	Bob	    Success
//        Match	Cpc	    Success
//        Skip	aax	    To be completed
//        Skip	bby	    To be completed
//        Skip	ccz	    To be completed
//        [ABC][nop][abc]   or  [ABC]\w+    or  [^abc]\w+

//        Match	wazzzzzup	Success
//        Match	wazzzup	    Success
//        Skip	wazup	    To be completed
//        waz{3,5}up

//        Match	aaaabcc	    Success
//        Match	aabbbbc	    Success
//        Match	aacc	    Success
//        Skip	a	    To be completed
//        a{2,4}(b{1,4})?c{1,2}     or  a{2,4}.+

//        Task	Text
//        Match	    1 file found?	    Success
//        Match	    2 files found?	    Success
//        Match	    24 files found?	    Success
//        Skip	    No files found.	    To be completed
//        ([0-9]+[ ])([a-z]+[ ])([a-z]+\?)  or  \d+(\s?\w+)+\?  or  \d+.+

//        Match	1.   abc	        Success
//        Match	2.	abc	            Success
//        Match	3.           abc	Success
//        Skip	4.abc	            To be completed
//        \s[\w]+   or  \s+.+

//        Match	    Mission: successful	                            Success
//        Skip	    Last Mission: unsuccessful	                    To be completed
//        Skip	    Next Mission: successful upon capture of target	Failed
//        [^LN][a-z]+[:][\s]successful  or   Mission: successful$

//        Match	    Mission: successful	        Success
//        Skip	    Last Mission: unsuccessful	To be completed
//        Skip	    Next Mission: successful upon capture of target
//                                              To be completed
//        [^LN][a-z]+[:][\s]successful$

//                                                    Capture group
//        Capture	file_record_transcript.pdf	    file_record_transcript	Success
//        Capture	file_07241999.pdf	            file_07241999	    Success
//        Skip	    testfile_fake.pdf.tmp		    To be completed
//        ^(file_record_transcript)?(file_07241999)?\.pdf   or  ^(file_?\w+).pdf$

//        Task	    Text	    Capture Groups
//        Capture	Jan 1987	Jan 1987 1987	Success
//        Capture	May 1969	May 1969 1969	Success
//        Capture	Aug 2011	Aug 2011 2011	Success
//        (Jan (1987)?)?(May (1969)?)?(Aug (2011)?)?    or  (\w+\s(\d+))

//        Task	Text	Capture Groups
//        Capture	1280x720	1280 720	Success
//        Capture	1920x1600	1920 1600	Success
//        Capture	1024x768	1024 768	Success
//        (\d{4})x(\d{3,4})     or  (\d+)x(\d+)

//        Match	    I love cats	    Success
//        Match	    I love dogs	    Success
//        Skip	    I love logs	    To be completed
//        Skip	    I love cogs	    To be completed
//        I love (cat|dog)s

//        Match	    The quick brown fox jumps over the lazy dog.	                Success
//        Match	    There were 614 instances of students getting 90.0% or above.	Success
//        Match	    The FCC had to censor the network for saying &$#*@!.	        Success
//        \D+(\d+)?\D+(\d+\.\d%\s(or above.))?      or  (\s?\w\s?)+(\D+)?(\d+)?%?(\s?\w)*\.?
//              or   (\s?\w\s?)*(\D+\d?%?)?(\s?\w)*\.   or  .+
//
//        Match	    3.14529	Success
//        Match	    -255.34	Success
//        Match	    128	    Success
//        Match	    1.9e10	Success
//        Match	    123,340.00	Success
//        Skip	    720p	Failed
//        [-]?[0-9]+\.?\,?[0-9]+[e]?[0-9]+\.?([0-9]+)?

//        Match	3.14529	    Success
//        Match	-255.34	    Success
//        Match	128	        Success
//        Match	1.9e10	    Success
//        Match	123,340.00	Success
//        Skip	720p	    To be completed
//        [-]?[\d]*[\.\,]?[\d]*e?[\.]?[\d]+$    or  ^-?\d+[\.\,]?(\d)*[e\.]?(\d)+$
//                                              or   -?\d+((\.|\,)?\d+)+(e\d+)*$
//

//        Capture	415-555-1234	415	Success
//        Capture	650-555-2345	650	Success
//        Capture	(416)555-3456	416	Success
//        Capture	202 555 4567	202	Success
//        Capture	4035555678	403	Success
//        Capture	1 416 555 9292	416	Success
//        (1\s)?\(?(\d{3})?\)?([\s-]?\d*)*  or  1?[\s-]?\(?(\d{3})\)?[\s-]?\d{3}[\s-]?\d{4} (someone's solution)
//        (\d\s)?(\(?(\d{3})\)?(\s?-?\d+)+)


//        Capture	tom@hogwarts.com	tom	Success
//        Capture	tom.riddle@hogwarts.com	tom.riddle	Success
//        Capture	tom.riddle+regexone@hogwarts.com	tom.riddle	Success
//        Capture	tom@hogwarts.eu.com	tom	Success
//        Capture	potter@hogwarts.com	potter	Success
//        Capture	harry@hogwarts.com	harry	Success
//        Capture	hermione+regexone@hogwarts.com	hermione	Success
//        (\w+(\.\w+)?)((@|\+)(\.?\w+)+)+   or
//        (\w+(\.?\w+))\+?(\w+)?@(\w+(\.?\w+)*) or
//        (\w+(\.\w+)?)(\+\w+)?@(\w+\.?)*

//        Capture	<a>This is a link</a>	a	Success
//        Capture	<a href='https://regexone.com'>Link</a>	a	Success
//        Capture	<div class='test_style'>Test</div>	div	Success
//        Capture	<div>Hello <span>world</span></div>	div	Success
//        <(a|div)[>\s]?(<?/?\w+\s?>?)+(='(https?://)?(\w+\.?)*')?>?\w+(</\w+>)+

//        Skip	.bash_profile		    To be completed
//        Skip	workspace.doc		    To be completed
//        Capture	img0912.jpg	img0912 jpg	Success
//        Capture	updated_img0912.png	updated_img0912 png	Success
//        Skip	documentation.html		To be completed
//        Capture	favicon.gif	favicon gif	Success
//        Skip	img0912.jpg.tmp		    To be completed
//        Skip	access.lock		        To be completed
//        ^(\w+).(jpg|png|gif)$

//        Capture				The quick brown fox...	    The quick brown fox...	Success
//        Capture	   jumps over the lazy dog.	            jumps over the lazy dog.	Success
//        (\s?)+((\w+\s?)+\.+)

//        Capture	E/( 1553):   at widget.List.makeView(ListView.java:1727)	makeView ListView.java 1727	Success
//        Capture	E/( 1553):   at widget.List.fillDown(ListView.java:652)	fillDown ListView.java 652	Success
//        Capture	E/( 1553):   at widget.List.fillFrom(ListView.java:709)	fillFrom ListView.java 709	Success
//        E/\((\s?\w+)\):\s+at\s(\.?(\w+))+\((\w+\.\w+)+:(\d+)\)

//        Exercise 8: Extracting Data From UPLs
//        (\w+)://([\w\.\-]+)(:(\d+))?/?(\D+)+\w+   // should work !


    }
    
    public String removeSpecialChars(String str) {
        return str.replaceAll("[^\\sa-zA-Z0-9]", "");
    }

}
