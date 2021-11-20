package models;

public interface IRecordStorage {
    /**
     * Добавляет рекорд
     * @param record
     */
    void add(Record record);

    /**
     * Загрузка всех рекордов
     * @return
     */
    Record[] load();
}
