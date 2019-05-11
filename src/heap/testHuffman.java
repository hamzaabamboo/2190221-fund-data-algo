package heap;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class testHuffman {

    @Test
    public void testBuildHuffmanTree02() throws Exception {
        Heap heap1 = new Heap();
        HuffmanNode a = new HuffmanNode(400, 'a', null, null);
        HuffmanNode b = new HuffmanNode(550, 'b', null, null);
        HuffmanNode c = new HuffmanNode(200, 'c', null, null);
        HuffmanNode d = new HuffmanNode(340, 'd', null, null);

        heap1.add(a);
        heap1.add(b);
        heap1.add(c);
        heap1.add(d);

        HuffmanNode r = HuffmanNode.buildHuffmanTree(heap1);

        HuffmanNode.printCodes(r);

        assertTrue(HuffmanNode.ans.contains("a: 10"));
        assertTrue(HuffmanNode.ans.contains("b: 0"));
        assertTrue(HuffmanNode.ans.contains("c: 110"));
        assertTrue(HuffmanNode.ans.contains("d: 111"));

        HuffmanNode.resetCodeArray();
        HuffmanNode.resetCodeString();
    }
    ////////////////////////////////////////////////////////////////

    @Test
    public void testBuildHuffmanTree03() throws Exception {

        Heap heap1 = new Heap();
        HuffmanNode a = new HuffmanNode(400, 'a', null, null);
        HuffmanNode b = new HuffmanNode(100, 'b', null, null);
        HuffmanNode c = new HuffmanNode(300, 'c', null, null);
        HuffmanNode d = new HuffmanNode(150, 'd', null, null);

        heap1.add(a);
        heap1.add(b);
        heap1.add(c);
        heap1.add(d);

        HuffmanNode r = HuffmanNode.buildHuffmanTree(heap1);

        HuffmanNode.printCodes(r);

        assertTrue(HuffmanNode.ans.contains("a: 0"));
        assertTrue(HuffmanNode.ans.contains("b: 100"));
        assertTrue(HuffmanNode.ans.contains("c: 11"));
        assertTrue(HuffmanNode.ans.contains("d: 101"));

        HuffmanNode.resetCodeArray();
        HuffmanNode.resetCodeString();
    }

    /////////////////////////////////////////////////////
    @Test
    public void testBuildHuffmanTree04() throws Exception {

        Heap heap1 = new Heap();
        HuffmanNode a = new HuffmanNode(300, 'a', null, null);
        HuffmanNode b = new HuffmanNode(250, 'b', null, null);
        HuffmanNode c = new HuffmanNode(500, 'c', null, null);
        HuffmanNode d = new HuffmanNode(100, 'd', null, null);

        heap1.add(a);
        heap1.add(b);
        heap1.add(c);
        heap1.add(d);

        HuffmanNode r = HuffmanNode.buildHuffmanTree(heap1);

        HuffmanNode.printCodes(r);

        assertTrue(HuffmanNode.ans.contains("a: 10"));
        assertTrue(HuffmanNode.ans.contains("b: 111"));
        assertTrue(HuffmanNode.ans.contains("c: 0"));
        assertTrue(HuffmanNode.ans.contains("d: 110"));

        HuffmanNode.resetCodeArray();
        HuffmanNode.resetCodeString();

    }

    @Test
    public void testBuildHuffmanTree05() throws Exception {

        Heap heap1 = new Heap();
        HuffmanNode a = new HuffmanNode(370, 'a', null, null);
        HuffmanNode b = new HuffmanNode(80, 'b', null, null);
        HuffmanNode c = new HuffmanNode(60, 'c', null, null);
        HuffmanNode d = new HuffmanNode(150, 'd', null, null);
        HuffmanNode e = new HuffmanNode(30, 'e', null, null);

        heap1.add(a);
        heap1.add(b);
        heap1.add(c);
        heap1.add(d);
        heap1.add(e);

        HuffmanNode r = HuffmanNode.buildHuffmanTree(heap1);

        HuffmanNode.printCodes(r);

        assertTrue(HuffmanNode.ans.contains("a: 1"));
        assertTrue(HuffmanNode.ans.contains("b: 010"));
        assertTrue(HuffmanNode.ans.contains("c: 0111"));
        assertTrue(HuffmanNode.ans.contains("d: 00"));
        assertTrue(HuffmanNode.ans.contains("e: 0110"));

        HuffmanNode.resetCodeArray();
        HuffmanNode.resetCodeString();

    }

}
