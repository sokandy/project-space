class List {

private int[] array=new int[30];
private int count;
private int pointer;
private boolean sign;

public List() {
  count=0;
  pointer=0;
  sign=true;
}

public void AddToFront(int n) {
  int i;
  for (i=count; i>=1; i--)
    array[i]=array[i-1];
  array[0]=n;
  count++;
}

public void AddToEnd(int n) {
  array[count++]=n;
}

public boolean GetFirst(Token token) {
  if (count==0)
    return true;
  else {
    pointer=0;
    token.setx(array[pointer]);
    return false;
  }
}

public boolean GetLast(Token token) {
  if (count==0)
    return true;
  else {
    pointer=count-1;
    token.setx(array[pointer]);
    return false;
  }
}

public boolean GetPrevious(Token token) {
  pointer--;
  if (pointer<0) {
    pointer=0;
    return true;
  } else {
    token.setx(array[pointer]);
    return false;
  }
}

public boolean GetNext(Token token) {
  pointer++;
  if (pointer==count) {
    pointer=count-1;
    return true;
  } else {
    token.setx(array[pointer]);
    return false;
  }
}

public int Size() { return count; }
public void Clear() { count=0; }
public boolean GetSign() { return sign; }
public void NegSign() { sign=false; }

}











