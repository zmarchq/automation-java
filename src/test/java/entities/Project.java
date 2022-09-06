package entities;

import java.util.List;


public class Project {
    private boolean valid;
    private List<String> tests;
    private Objects objects;
    private String name;

    public boolean isValid() {
        return valid;
    }

    public List<String> getTests() {
        return tests;
    }

    public Objects getObjects() {
        return objects;
    }

    public String getName() {
        return name;
    }

    public static class Objects {
        private List<String> components;
        private List<String> testData;
        private List<String> pages;

        public List<String> getComponents() {
            return components;
        }

        public List<String> getTestData() {
            return testData;
        }

        public List<String> getPages() {
            return pages;
        }
    }
}

