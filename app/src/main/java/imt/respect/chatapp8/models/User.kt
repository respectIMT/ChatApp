package imt.respect.chatapp8.models

class User{
    var displayName:String? = null
    var imageLink:String? = null
    var uid:String? = null



    constructor(displayName: String?, imageLink: String?, uid: String?) {
        this.displayName = displayName
        this.imageLink = imageLink
        this.uid = uid
    }
    constructor()
}
