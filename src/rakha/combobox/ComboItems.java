package rakha.combobox;

public class ComboItems {

    private Long key;
    private String value;

    public ComboItems(Long key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public Long getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
