## Regular Expressions

**Thinking in Java, Ed. 4**

- Originially from Unix utilities like sed and awk
- Also a part of languages like Python and Perl
- Something about escaping characters and its irrelevance in Java
- Java libraries `java.util.regex.Pattern` and `java.util.regex.Matcher`
- Charcters:
  - *B* -> is just a character
  - *\xhh* -> Character with hex value
  - *\uhhhh* -> The Unicode character with hex representation 0xhhhh
  - *\t* -> Tab
  - *\n* -> NewLine
  - *\r* -> Carriage return
  - *\f* -> form feed
  - *\e* -> Escape
  - *.* -> Any chacter
  - *[abc]* -> Any of the characters a, b, or c (same as a|b|c)
  - *[^abc]* -> Any character except a, b, and c (negation)
  - *[a-zA-Z]* -> Any character a through z or A through Z (range)
  - *[abc[hij]]* -> ny of a,b,c,h,I,j (same as a|b|c|h|i|j) (union)
  - *\s* -> A whitespace character (space, tab, newline, form feed, carriage return)
  - *\S* -> A non-whitespace character ([^\s])
  - *\d* -> A numeric digit [0-9]
  - *\D* -> A non-digit [^0-9]
  - *\w* -> A word character [a-zA-Z_0-9]
  - *\W* ->  A non-word character [^\w]
- Boundary Matchers
  - *^* -> Beginning of a line
  - *$* -> End of a line
  - *\b* -> Word boundary
  - *\B* -> Non-word boundary
  - *\G* -> End of the previous match
  
  ## Project Notes
  - JSON Line Parse: `("[A-Z_\.]+":\s(""|"[A-Za-z0-9-\/\s']+"))`
  - JSON Block Selector: `(\{\s+("[\w\.]+":\s"[\w\/'\s]+",?\s+)+\})`
  - Key Value: `(\w+\s?(\.?)(\/?)('?))+`
  
  ### HackerRank Stuff
  - [Winning Answer](https://www.hackerrank.com/challenges/valid-username-checker) `"^(?!\\W)([a-zA-z][\\w]{7,29})$"`
    - Don't forget index ranges with regex still begin at zero
  - [Partially working](https://www.hackerrank.com/challenges/java-regex) `^(((\\d\\d)|(0\\d{0,2})|(1\\d*\\d*)|(2[0-4]\\d*)|(2[0-5][0-5]))\\.?){3,4}$`