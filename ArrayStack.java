package part2;

/**
 *
 * @author akali
 * 
 */

public class ArrayStack {
    private String[] array = new String[1];
    private int N = 0;
     
    public boolean isEmpty(){
        return N == 0;
    }
    
    public void push(String item){
        if(N == array.length)resize(2*array.length);
        array[N++] = item;
    }
    
    public String pop(){
        if(N == 0)return null;
        String item = array[--N];
        array[N] = null;
        if(N > 0 && N == array.length / 4) resize(array.length / 2);
        return item;
    }
    
    public int size(){
        return N;
    }
    
    public String peek(){
        return array[N-1];
    }
    
    private void resize(int size){
        String[] copy = new String[size];
        for(int i=0;i<N;i++){
            copy[i] = array[i];
        }
        array = copy;
    }
    
    
}
