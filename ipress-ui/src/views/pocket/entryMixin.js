import {saveEntry, updateEntry} from '../../api/pocketApi'

export default {
    data() {
        return {
            showPageDrawer: false,
            entryId: undefined,
            entryItem: {
                "parentMenuId": "",
                "title": "",
                "mdContent": "",
            }
        }
    },
    methods: {
        editEntry(id, item) {
            this.entryId = id
            this.entryItem = Object.assign({
                name: '',
                parentId: undefined,
                mdContent: '',
                sort: 0,
                pocketId: this.id
            }, item)
            this.showPageDrawer = true
        },
        submitEntry() {
            if (this.entryId) {
                updateEntry(this.entryId, this.entryItem).then(() => {
                    this.loadAllData()
                    this.showPageDrawer = false
                })
            } else {
                saveEntry(this.entryItem).then(() => {
                    this.loadAllData()
                    this.showPageDrawer = false
                })
            }
        }
    },
}