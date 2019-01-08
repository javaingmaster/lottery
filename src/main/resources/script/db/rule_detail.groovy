package script.db

databaseChangeLog(logicalFilePath: 'rule_detail.groovy') {
    changeSet(id: '2019-01-07-rule-detail', author: 'zty') {
        createTable(tableName: "rule_detail") {
            column(name: 'detail_id', type: 'BIGINT UNSIGNED', remarks: 'detail id', autoIncrement: true) {
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
            column(name: 'lottery_object_id', type: 'BIGINT UNSIGNED', remarks: 'object id') {
            }
            column(name: 'object_ratio', type: 'FLOAT', remarks: 'object ratio') {
                constraints(nullable: true)
            }
        }
    }
}