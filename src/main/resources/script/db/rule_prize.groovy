package script.db

databaseChangeLog(logicalFilePath: 'rule_prize.groovy') {
    changeSet(id: '2019-01-07-rule-prize', author: 'zty') {
        createTable(tableName: "rule_prize") {
            column(name: 'rule_prize_id', type: 'BIGINT UNSIGNED', remarks: 'rule prize id', autoIncrement: true) {
                constraints(nullable: false, primaryKey: true)
            }
            column(name: 'rule_id', type: 'BIGINT UNSIGNED', remarks: 'rule id') {
                constraints(nullable: false)
            }
            column(name: 'prize_id', type: 'BIGINT UNSIGNED', remarks: 'prize id') {
            }
            column(name: 'prize_ratio', type: 'FLOAT', remarks: 'prize ratio') {
                constraints(nullable: true)
            }
        }
    }
}