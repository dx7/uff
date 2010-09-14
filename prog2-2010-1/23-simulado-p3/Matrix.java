class Matrix {
  
  public int[][] values;
  
  public Matrix(int[][] it) {
    values = it;
  }
  
  public int[][] plus(int it[][]) {
    int[][] sum = values.clone();
    
    for (int i = 0; i < it.length; i++) {
      for (int j = 0; j < it[i].length; j++) {
        if(it.length != values.length || it[i].length != values[i].length) return null;
        
        sum[i][j] = values[i][j] + it[i][j];
      }
    }
    
    return sum;
  }
  
  public int[][] minus(int it[][]) {
    int[][] sub = values.clone();
    
    for (int i = 0; i < it.length; i++) {
      for (int j = 0; j < it[i].length; j++) {
        if(it.length != values.length || it[i].length != values[i].length) return null;
        
        sub[i][j] = values[i][j] - it[i][j];
      }
    }
    
    return sub;
  }
  
  public int[][] times(int it[][]) {
    if (values.length != it[0].length) return null;
    
    int[][] result = new int[values.length][it[0].length];
    
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[i].length; j++) {
        for (int k = 0; k < result[j].length; k++) {
          result[i][j] += values[i][k] * it[k][j];
        }
      }
    }
    
    return result;
  }
  
  public int[][] times(int it) {
    int[][] result = values.clone();
    
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[i].length; j++) {
        result[i][j] = values[i][j] * it;
      }
    }
    
    return result;
  }
}