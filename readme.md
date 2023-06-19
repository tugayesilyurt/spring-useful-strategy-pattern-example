# Two useful Strategy Pattern example ( java,spring boot )

Two Strategy Pattern
------------
- `Enumaration Strategy Pattern`

```java
@Component
public enum EnumerationCommand implements EnumerationCommandStrategy{

    ADDITION("Addition") {
        @Override
        public Integer execute(Integer firstValue,Integer secondValue) {

            return firstValue + secondValue;

        }
    },MINUS("Minus") {
        @Override
        public Integer execute(Integer firstValue,Integer secondValue) {

            return firstValue - secondValue;

        }
    },MULTIPLY("Multiply") {
        @Override
        public Integer execute(Integer firstValue,Integer secondValue) {

            return firstValue * secondValue;

        }
    }, DIVIDE("Divide") {
        @Override
        public Integer execute(Integer firstValue,Integer secondValue) {

            return firstValue / secondValue;

        }
    },OTHER("Other") {
        @Override
        public Integer execute(Integer firstValue,Integer secondValue) {

            System.out.println("Do nothing!");
            return null;
        }
    };

    public final String type;

    EnumerationCommand(String type) {
        this.type = type;
    }

    public static EnumerationCommand getEnumerationCommandType(String type) {
        return Arrays.stream(EnumerationCommand.values()).filter(enumValue -> type.equalsIgnoreCase(enumValue.type)).findFirst()
                .orElse(EnumerationCommand.OTHER);
    }
}
```

- `HashMap - Bean Strategy Pattern ( ListableBeanFactory )` 

```java
@Component
public class Addition implements HashMapCommandStrategy {
    @Override
    public Integer execute(Integer firstValue, Integer secondValue) {
        return firstValue + secondValue;
    }

    @Override
    public String getType() {
        return "Addition";
    }
}
```








