package BusinessLayer;

import dao.DocumentDao;
import java.awt.Color;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Document {
    private int docid;
    private String docName;
    private Color color;
    private int lineCount;
    private int wordCount;
    private int pageCount;
    private User owner;
    private boolean isFavourite;
    private List<Document> versionHistory;
    private List<SharingInfo> sharedWith;
    private List<DocumentElement> documentElements;
    private HashMap<User, Boolean> permissionsList;
    private Date createdDate;
    private Date lastModifiedDate;
    private int positionTracker = -1;
    DocumentDao documentDao;

    public Document(){
        versionHistory = new LinkedList<>();
        sharedWith = new LinkedList<>();
        documentElements = new LinkedList<>();
        permissionsList = new HashMap<>();  
        createdDate = new Date();
        isFavourite = false;
        color = Color.WHITE;
    }
    
    public void setLastModifiedDate(Date date){
        lastModifiedDate = date;
    }
    
    public Date getLastModifiedDate(){
        return lastModifiedDate;
    }
    
    public int getPositionTracker(){
        return positionTracker;
    }
    
    public void setPositionTracker(){
        positionTracker++;
    }
        
    public int getDocid() {
        return docid;
    }

    public void setDocid(int docid) {
        this.docid = docid;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        System.out.println("Color Updated! " + color);
        this.color = color;
    }

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public List<Document> getVersionHistory() {
        return versionHistory;
    }

    public void setVersionHistory(List<Document> versionHistory) {
        this.versionHistory = versionHistory;
    }

    public List<SharingInfo> getSharedWith() {
        return sharedWith;
    }

    public void setSharedWith(List<SharingInfo> sharedWith) {
        this.sharedWith = sharedWith;
    }

    public List<DocumentElement> getDocumentElements() {
        return documentElements;
    }

    public void setDocumentElements(List<DocumentElement> documentElements) {
        this.documentElements = documentElements;
    }

    public HashMap<User, Boolean> getPermissionsList() {
        return permissionsList;
    }

    public void setPermissionsList(HashMap<User, Boolean> permissionsList) {
        this.permissionsList = permissionsList;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setDao(DocumentDao dao){
        this.documentDao = dao;
    }
        
    
    public void editName(String name){
   
    }
    
    public void insertElement(DocumentElement element){
        documentElements.add(element);
    }
    
    public void deleteElement(DocumentElement element){
        documentElements.remove(element);
    }
    
    public List<DocumentElement> getDocumentElement(){
        return null;
    }
    
    public boolean addBulletPoints(){
        return false;
    }
    
    public boolean markAsFavourite(){
        return false;
    }
    
    public boolean shareDocument(User user){
        return false;
    }
    
    public boolean setPerviousVersion(Document document){
        return false;
    }
    
    public Document getVersion(int versionID){
        return this;
    }
    
    public void updateVersionHistory(Document document){
        
    }
    
    
    public boolean exportDocument(String exportType){
        return false;
    }
    
    public boolean saveDocument(){
        return documentDao.saveDocument(this,documentElements);
    }
    
    public void printDocumentInfo() {
    System.out.println("Document Information:");
    System.out.println("Document ID: " + docid);
    System.out.println("Document Name: " + docName);
    System.out.println("Color: " + color);
    System.out.println("Line Count: " + lineCount);
    System.out.println("Word Count: " + wordCount);
    System.out.println("Page Count: " + pageCount);
    System.out.println("Owner: " + owner.getUsername()); // Assuming User class has a getUsername() method
    System.out.println("Favourite: " + isFavourite);
    System.out.println("Created Date: " + createdDate);
    System.out.println("Last Modified Date: " + lastModifiedDate);

//    System.out.println("\nVersion History:");
//    for (Document version : versionHistory) {
//        System.out.println("Version ID: " + version.getDocid());
//        // Print additional version information if needed
//    }

//    System.out.println("\nShared With:");
//    for (SharingInfo sharingInfo : sharedWith) {
//        System.out.println("User: " + sharingInfo.getUser().getUsername() + ", Permission: " + sharingInfo.getPermission());
//    }

//    System.out.println("\nPermissions List:");
//    for (User user : permissionsList.keySet()) {
//        System.out.println("User: " + user.getUsername() + ", Permission: " + permissionsList.get(user));
//    }

    System.out.println("\nDocument Elements:");
    for (DocumentElement element : documentElements) {
        element.displayDocumentElement();
    }
}

    
}


