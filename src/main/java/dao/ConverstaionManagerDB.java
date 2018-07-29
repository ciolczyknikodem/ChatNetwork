package dao;

interface ConverstaionManagerDB {

    void find(Converstaion converstaion);
    void update(Conversation conversation);
    void createTableHistory(int[] users);

}
