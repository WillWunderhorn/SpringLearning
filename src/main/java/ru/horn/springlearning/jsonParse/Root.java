package ru.horn.springlearning.jsonParse;

import java.util.List;

public class Root {
    private List<Datasource> datasources;

    public List<Datasource> getDatasources() {
        return datasources;
    }

    public void setDatasources(List<Datasource> datasources) {
        this.datasources = datasources;
    }

    @Override
    public String toString() {
        return "JsonParse{" +
                "datasources=" + datasources +
                '}';
    }
}
