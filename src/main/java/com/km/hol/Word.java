package com.km.hol;

class Word {
    private String dutch;
    private String polish;

    Word(String dutch, String polish) {
        this.dutch = dutch;
        this.polish = polish;
    }

    public String getDutch() {
        return dutch;
    }

    public String getPolish() {
        return polish;
    }
}
