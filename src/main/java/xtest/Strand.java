package xtest;

import java.util.stream.IntStream;

public class Strand {

    public long charCount(String first, String second) {

        return IntStream.range(0, first.length())
                .filter(i -> first.charAt(i) != second.charAt(i))
                .count();
    }


    public static void main(String[] args) {

        Strand strand = new Strand();

        System.out.println(strand.charCount("abcdefg", "axcxxefx"));

    }

}

/*
for (int i = 0; i < firstStrand.Length; i++)
        {
        if (firstStrand.charAt(i) != secondStrand.charAt(i))
        {
        result++;
        }
        } */