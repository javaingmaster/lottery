package script.db

databaseChangeLog(logicalFilePath: 'record.groovy') {
    changeSet(id: '2019-01-07-record', author: 'zty') {
        createTable(tableName: "lottery_record") {
            column(name: 'record_id', type: 'BIGINT UNSIGNED', remarks: 'recordid', autoIncrement: true) {
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'record_type', type: 'TINYINT', remarks: 'person or group') {
                constraints(nullable: false)
            }
            column(name: 'lucky_dog_id', type: 'BIGINT UNSIGNED', remarks: 'lucky dog') {
                constraints(nullable: false)
            }
            column(name: 'lucky_time', type: 'DATETIME', remarks: 'lucky time') {
                constraints(nullable: false)
            }
            column(name: 'prize_id', type: 'BIGINT UNSIGNED', remarks: 'prize') {
            }

        }
    }
}