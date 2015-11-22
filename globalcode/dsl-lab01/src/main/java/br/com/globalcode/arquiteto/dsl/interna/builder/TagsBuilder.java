package br.com.globalcode.arquiteto.dsl.interna.builder;

import java.util.ArrayList;
import java.util.List;

public class TagsBuilder {
    private final List<String> tags;

    public TagsBuilder(String... tags) {
        this.tags = new ArrayList<String>();

        for (String string : tags) {
            this.tags.add(string);
        }
    }

    public List<String> getTags() {
        return tags;
    }
}
