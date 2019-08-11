package model;

public interface PorkerTypeIndexConstant {
    int INDEXLENTH = 19;
    int TWOPAIRINDEX = Poker.dictionary.length();
    int THREEPAIRINDEX = TWOPAIRINDEX + 1;
    int STRAIGHTINDEX = THREEPAIRINDEX + 1;
    int FLUSHINDEX = STRAIGHTINDEX + 1;
    int FULLHOUSEINDEX = FLUSHINDEX + 1;
    int FOUROFAKINDINDEX = FULLHOUSEINDEX + 1;
}
