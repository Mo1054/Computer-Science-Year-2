
  
  //Single arrays
  //Even
    let A = [];
  //Odd
    let B = [];
  
    //Pushing values into arrays
    for (let i = 1; i <= 100 * 2; i++) {
      if (i % 2 == 0) {
        A.push(i);
      }
  
      if (i % 2 == 1) {
        B.push(i);
      }
    }


    //Square Matrixs;
    let C = [];
    n = 50;
    for(let i = 0; i < n; i++){

      
       C[i] = [i];
      for(let j = 0; j < n; j++ ){

        C[i][j] = [j];

      }
    }

    X = [1,2,3,4];

    console.log(C);
    


    
  
 





    
     
    // console.log(ALG2(A,0,A.length - 1));
    // console.log(ALG2(B,0,B.length-1));


  //Alogrithm 1
  function ALG1(A,B,N){
   if(N==0){
        return 0
   }
   return A[N-1]*B[N-1]+ALG1(A,B,N-1) 

  }





  //Alogrith 2
  function ALG2(A,low,high){
    
   if(high-low==1)
          if(A[low]<A[high])
              return high
          else
              return low
      if (low==high)
          return high
      mid=low+Math.floor((high-low)/2)
      a=ALG2(A,low,mid)
      b=ALG2(A,mid+1,high)
     if(A[a]>A[b])
          return a
     return b
  
  
  }

  //alogorithm 3
  function ALG3(A,N){
    if(N==0){
        return 0
      }
    return A[N-1,N-1]+ALG3(A,N-1)
  }


  //alogirth 4 
  function ALG4(A,B,N){
    if(N==0){
        return 0
    }
    return A[N-1][N-1]+B[N-1][N-1]+ALG4(A,B,N-1)+ALG4(A,B,N-1)
  }

    
    
    
  