public class StudentList extends CDLinkedList {
    // you can write additional methods.


    // implement this method
    public void removeStudent(String id) throws Exception {
        DListIterator itr = new DListIterator(this.header);
        while (itr.hasNext() && itr.currentNode.nextNode != header) {
            if (((Student) itr.currentNode.nextNode.data).getId().equals(id)) remove(itr);
            itr.next();
        }
    }

    // implement this method
    public void appendQuick(CDLinkedList list2) throws Exception {
        if (list2.isEmpty()) return;
        DListNode list2header = list2.header.nextNode;
        DListNode list2tail = list2.header.previousNode;

        this.header.previousNode.nextNode = list2header;
        list2header.previousNode = this.header.previousNode;
        this.header.previousNode = list2tail;
        list2tail.nextNode = this.header;
    }

    // implement this method
    public void append(CDLinkedList list2) throws Exception {
        DListIterator list2Itr = new DListIterator(list2.header);
        DListIterator itr = new DListIterator(this.header.previousNode);
        list2Itr.next();
        while (list2Itr.hasNext() && list2Itr.currentNode != list2.header) {
            Student current = ((Student) list2Itr.currentNode.data).createCopy();
            this.insert(current, itr);
            list2Itr.next();
            itr.next();
        }
    }

    // implement this method
    public CDLinkedList gender(int i) throws Exception {
        String sex = i == 0 ? "male" : (i == 1 ? "female" : null);
        CDLinkedList res = new StudentList();
        DListIterator resItr = new DListIterator(res.header);
        DListIterator itr = new DListIterator(this.header);
        itr.next();
        if (sex == null) return null;
        while (itr.hasNext() && itr.currentNode != header) {
            if (((Student) itr.currentNode.data).getSex().equals(sex)) {
                Student current = ((Student) itr.currentNode.data).createCopy();
                res.insert(current, resItr);
                resItr.next();
            }
            itr.next();
        }
        return res;
    }
}
