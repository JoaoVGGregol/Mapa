
public class GenericMapTest {
    public static void main(String[] args) {
        GenericMap<String, Integer> map = new GenericMap<>();

        // Teste put e get
        map.put("cinco", 5);
        map.put("sete", 7);
        map.put("um", 1);
        System.out.println("cinco: " + map.get("cinco"));
        System.out.println("sete: " + map.get("sete"));
        System.out.println("três: " + map.get("três"));
        System.out.println("quatro: " + map.get("quatro"));

        // Teste remove
        map.remover("dois");
        System.out.println("dois: " + map.get("dois"));
        System.out.println("sete: " + map.get("oito"));
    }
}
