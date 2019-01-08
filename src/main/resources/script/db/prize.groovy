package script.db

databaseChangeLog(logicalFilePath: 'prize.groovy') {
    changeSet(id: '2019-01-07-prize', author: 'zty') {
        createTable(tableName: "lottery_prize") {
            column(name: 'prize_id', type: 'BIGINT UNSIGNED', remarks: 'prizeid', autoIncrement: true) {
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'prize_name', type: 'VARCHAR(20)', remarks: 'name of prize') {
            constraints(nullable: false)
            }

            column(name: 'prize_worth', type: 'INT', remarks: 'worth of prize') {
                constraints(nullable: true)
            }
            column(name: 'prize_stock', type: 'INT', remarks: 'prize numbers') {
                constraints(nullable: false)
            }

            column(name: 'prize_ratio', type: 'FLOAT', remarks: 'ratio') {
                constraints(nullable: true)
            }
        }
    }
}