import java.awt.Graphics;
import java.applet.Applet;
import java.awt.Color;

public class main2 extends java.applet.Applet{
  
  Color col1,col2,col3;
  int N,taka,haba;
  int k,i,j,l;
  double di,di2,di3,cp2,cpx;
  double x1max,x1min,y1max,y1min;
  double yen,yst,yst2,yen2,yst3,yen3;
  double xst,xen,xst2,xen2,xst3,xen3,ymin,ymax;
  double ds,us,xx,yy2;
  double a,b,ak,bk;

  double dik,di2k,di3k,cp2k,cpxk;
  double x1maxk,x1mink,y1maxk,y1mink,x1x1,y1y1;
  double yenk,ystk,yst2k,yen2k,yst3k,yen3k;
  double xstk,xenk,xst2k,xen2k,xst3k,xen3k;
  int br,br2,u,k2;
  int xz,xz2,yz,yz2;
  String NS,habaS,takaS;
  double Nd,takad,habad;
  Color cl[]=new Color[13];
  double kx[]=new double[100];
  double ky[]=new double[100];
  double kz[]=new double[100];

  
  public double dou(String dous){
    double dou1;
    dou1 = (Double.valueOf(dous)).doubleValue();
    return dou1;
  }

  
  public double rand(){
    double rand1;
    rand1=Math.random();
    return rand1;
  }

  
  public void init(){
    col1=Color.;
    col2=Color.green;
    col3=Color.blue;
    cl[0]=Color.yellow;
    cl[1]=Color.green;
    cl[2]=Color.yellow;

    
    takaS=getParameter("takap");
    habaS=getParameter("habap");
    NS=getParameter("Np");
    habad=dou(habaS);
    takad=dou(takaS);
    Nd=dou(NS);
  
      Nd=4+16*rand();
  
    
    haba=(int)habad;
    taka=(int)takad;
    
    N=(int)Nd;
  }

  
  double x1[]=new double[100];
  double y1[]=new double[100];
  int x[]=new int[100];
  int y[]=new int[100];
  double s[]=new double[100];
  String sss[]=new String[100];

  
  public double jou(double aj,double bj){
    double jou1;
    jou1=Math.pow(aj,bj);
    return jou1;
  }

  
  public double abso(double ab1){
    double abab;
    if(ab1>0){
      abab=ab1;
    }
    else{
      abab=-ab1;
    }
    return abab;
  }

  
  
  public double dis(double ad,double bd,double ad2,double bd2){
    double dis1;
    dis1=abso(ad-ad2)+abso(bd-bd2);
    return dis1;
  }

  

  
  public double koutenx(double as,double bs,double ask,double bsk){
    double aaa1;
    aaa1=(bsk-bs)/(as-ask);
    return aaa1;
  }

  
  public double kouteny(double as2,double bs2,double ask2,double bsk2){
    double aaa2;
    aaa2=(bs2/as2-bsk2/ask2)/(1.0/as2-1.0/ask2);
    return aaa2;
  }


  
  
  void heapv(double te1[],double te2[],double te3[],int NN){
    int kk,kks,ii,jj,mm;
    double b1,b2,b3,c1,c2,c3;
    kks=(int)(NN/2);
    for(kk=kks;kk>=1;kk--){
      ii=kk;
      b1=te1[ii-1];b2=te2[ii-1];b3=te3[ii-1];
      while(2*ii<=NN){
        jj=2*ii;
        if(jj+1<=NN){
          if(te1[jj-1]<te1[jj]){
            jj++;
          }
        }
        if(te1[jj-1]<=b1){
          break;
        }
        te1[ii-1]=te1[jj-1];te2[ii-1]=te2[jj-1];te3[ii-1]=te3[jj-1];
        ii=jj;
      }
      te1[ii-1]=b1;te2[ii-1]=b2;te3[ii-1]=b3;
    }
    for(mm=NN-1;mm>=1;mm--){
      c1=te1[mm];c2=te2[mm];c3=te3[mm];
      te1[mm]=te1[0];te2[mm]=te2[0];te3[mm]=te3[0];
      ii=1;
      while(2*ii<=mm){
        kk=2*ii;
        if(kk+1<=mm){
          if(te1[kk-1]<=te1[kk]){
            kk++;
          }
        }
        if(te1[kk-1]<=c1){
          break;
        }
        te1[ii-1]=te1[kk-1];te2[ii-1]=te2[kk-1];te3[ii-1]=te3[kk-1];
        ii=kk;
      }
      te1[ii-1]=c1;te2[ii-1]=c2;te3[ii-1]=c3;
    }
  }

  
  public void paint(java.awt.Graphics g){
    g.setColor(col1);
    g.fillRect(1,1,haba,taka);
    g.setColor(col3);

    
    for(k=0;k<N;k++){
      x1[k]=rand()*(haba-30)+15;
      y1[k]=rand()*(taka-30)+15;
      x[k]=(int)(x1[k]+0.5);
      y[k]=(int)(y1[k]+0.5);
      s[k]=jou(x1[k]*x1[k]+y1[k]*y1[k],0.5);
    }
    g.setColor(col2);
    
    for(k=0;k<N;k++){
      g.fillOval(x[k]-2,y[k]-2,4,4);
    }

    for(i=1;i<=N-1;i++){
      for(j=i+1;j<=N;j++){
                                                        
        if(abso(x1[i-1]-x1[j-1])<abso(y1[i-1]-y1[j-1])){

          x1max=x1[i-1];
          x1min=x1[j-1];
          if(x1[i-1]<x1[j-1]){
            x1max=x1[j-1];
            x1min=x1[i-1];
          }
          y1max=y1[i-1];
          y1min=y1[j-1];
          if(y1[i-1]<y1[j-1]){
            y1max=y1[j-1];
            y1min=y1[i-1];
          }
          cp2=(y1[i-1]+y1[j-1])/2;
          cpx=(x1[i-1]+x1[j-1])/2;
                                                    
                                                    
          if((x1[i-1]-x1[j-1])*(y1[i-1]-y1[j-1])>0){
            di=-1.0+rand()/1000.0;
            yst=di*(x1min-cpx)+cp2;
            yen=di*(x1max-cpx)+cp2;
            l=1;
            kx[l-1]=x1min;
            ky[l-1]=di*(kx[l-1]-cpx)+cp2;
            l++;
            kx[l-1]=x1max;
            ky[l-1]=di*(kx[l-1]-cpx)+cp2;
            a=di;
            b=-di*cpx+cp2;
            for(k=1;k<=N;k++){
              if(k!=i && k!=j){
                x1maxk=x1[i-1];
                x1mink=x1[k-1];
                if(x1[i-1]<x1[k-1]){
                  x1maxk=x1[k-1];
                  x1mink=x1[i-1];
                }
                y1maxk=y1[i-1];
                y1mink=y1[k-1];
                if(y1[i-1]<y1[k-1]){
                  y1maxk=y1[k-1];
                  y1mink=y1[i-1];
                }
                cp2k=(y1[i-1]+y1[k-1])/2.0;
                cpxk=(x1[i-1]+x1[k-1])/2.0;
                                                    
                if(abso(x1[i-1]-x1[k-1])<abso(y1[i-1]-y1[k-1])){
                                                    
                  if((x1[i-1]-x1[k-1])*(y1[i-1]-y1[k-1])>0){
                    dik=-1.0+rand()/1000.0;
                    ystk=dik*(x1mink-cpxk)+cp2k;
                    yenk=dik*(x1maxk-cpxk)+cp2k;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    di2k=-rand()/800.0;
                    ak=di2k;
                    bk=-di2k*x1mink+ystk;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=-rand()/800.0;
                    ak=di3k;
                    bk=-di3k*x1maxk+yenk;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                                                    
                                                    
                  else{
                    dik=1.0+rand()/1000.0;
                    ystk=dik*(x1mink-cpxk)+cp2k;
                    yenk=dik*(x1maxk-cpxk)+cp2k;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di2k=rand()/800.0;
                    ak=di2k;
                    bk=-di2k*x1mink+ystk;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=rand()/800.0;
                    ak=di3k;
                    bk=-di3k*x1maxk+yenk;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                }

                     
                    
                else{
                  if((x1[i-1]-x1[k-1])*(y1[i-1]-y1[k-1])>0){
                    dik=-1.0+rand()/800.0;
                    xstk=(y1mink-cp2k)/dik+cpxk;
                    xenk=(y1maxk-cp2k)/dik+cpxk;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    di2k=-800.0+rand()/800.0;
                    ak=di2k;
                    bk=-di2k*xstk+y1mink;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=-800.0+rand()/800.0;
                    ak=di3k;
                    bk=-di3k*xenk+y1maxk;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                  else{
                    dik=1.0+rand()/1000.0;
                    xstk=(y1mink-cp2k)/dik+cpxk;
                    xenk=(y1maxk-cp2k)/dik+cpxk;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di2k=800.0+rand()/800.0;
                    ak=di2k;
                    bk=-di2k*xstk+y1mink;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=800.0+rand()/800.0;
                    ak=di3k;
                    bk=-di3k*xenk+y1maxk;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                }
              }
            }
            di2=-rand()/800.0;
            yst2=di2*(0.0-x1min)+yst;
            yen2=di2*(x1min-x1min)+yst;
            l++;
            kx[l-1]=0.0;
            ky[l-1]=di2*(kx[l-1]-x1min)+yst;
            a=di2;
            b=-di2*x1min+yst;
            for(k=1;k<=N;k++){
              if(k!=i && k!=j){
                x1maxk=x1[i-1];
                x1mink=x1[k-1];
                if(x1[i-1]<x1[k-1]){
                  x1maxk=x1[k-1];
                  x1mink=x1[i-1];
                }
                y1maxk=y1[i-1];
                y1mink=y1[k-1];
                if(y1[i-1]<y1[k-1]){
                  y1maxk=y1[k-1];
                  y1mink=y1[i-1];
                }
                cp2k=(y1[i-1]+y1[k-1])/2.0;
                cpxk=(x1[i-1]+x1[k-1])/2.0;
                if(abso(x1[i-1]-x1[k-1])<abso(y1[i-1]-y1[k-1])){
                  if((x1[i-1]-x1[k-1])*(y1[i-1]-y1[k-1])>0){
                    dik=-1.0+rand()/1000.0;
                    ystk=dik*(x1mink-cpxk)+cp2k;
                    yenk=dik*(x1maxk-cpxk)+cp2k;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                  else{
                    dik=1.0+rand()/1000.0;
                    ystk=dik*(x1mink-cpxk)+cp2k;
                    yenk=dik*(x1maxk-cpxk)+cp2k;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                }
                else{
                  if((x1[i-1]-x1[k-1])*(y1[i-1]-y1[k-1])>0){
                    dik=-1.0+rand()/1000.0;
                    xstk=(y1mink-cp2k)/dik+cpxk;
                    xenk=(y1maxk-cp2k)/dik+cpxk;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di2k=-800.0+rand()/800.0;
                    ak=di2k;
                    bk=-di2k*xstk+y1mink;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=-800.0+rand()/800.0;
                    ak=di3k;
                    bk=-di3k*xenk+y1maxk;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                  else{
                    dik=1.0+rand()/1000.0;
                    xstk=(y1mink-cp2k)/dik+cpxk;
                    xenk=(y1maxk-cp2k)/dik+cpxk;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di2k=800.0+rand()/800.0;
                    ak=di2k;
                    bk=-di2k*xstk+y1mink;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=800.0+rand()/800.0;
                    ak=di3k;
                    bk=-di3k*xenk+y1maxk;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                }
              }
            }

            di3=-rand()/800.0;
            yst3=di3*(x1max-x1max)+yen;
            yen3=di3*(haba-x1max)+yen;
            l++;
            kx[l-1]=haba;
            ky[l-1]=di3*(kx[l-1]-x1max)+yen;
            a=di3;
            b=-di3*x1max+yen;
            for(k=1;k<=N;k++){
              if(k!=i && k!=j){
                x1maxk=x1[i-1];
                x1mink=x1[k-1];
                if(x1[i-1]<x1[k-1]){
                  x1maxk=x1[k-1];
                  x1mink=x1[i-1];
                }
                y1maxk=y1[i-1];
                y1mink=y1[k-1];
                if(y1[i-1]<y1[k-1]){
                  y1maxk=y1[k-1];
                  y1mink=y1[i-1];
                }
                cp2k=(y1[i-1]+y1[k-1])/2.0;
                cpxk=(x1[i-1]+x1[k-1])/2.0;
                if(abso(x1[i-1]-x1[k-1])<abso(y1[i-1]-y1[k-1])){
                  if((x1[i-1]-x1[k-1])*(y1[i-1]-y1[k-1])>0){
                    dik=-1.0+rand()/1000.0;
                    ystk=dik*(x1mink-cpxk)+cp2k;
                    yenk=dik*(x1maxk-cpxk)+cp2k;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                  else{
                    dik=1.0+rand()/1000.0;
                    ystk=dik*(x1mink-cpxk)+cp2k;
                    yenk=dik*(x1maxk-cpxk)+cp2k;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                }
                else{
                  if((x1[i-1]-x1[k-1])*(y1[i-1]-y1[k-1])>0){
                    dik=-1.0+rand()/1000.0;
                    xstk=(y1mink-cp2k)/dik+cpxk;
                    xenk=(y1maxk-cp2k)/dik+cpxk;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di2k=-800.0+rand()/800.0;
                    ak=di2k;
                    bk=-di2k*xstk+y1mink;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=-800.0+rand()/800.0;
                    ak=di3k;
                    bk=-di3k*xenk+y1maxk;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                  else{
                    dik=1.0+rand()/1000.0;
                    xstk=(y1mink-cp2k)/dik+cpxk;
                    xenk=(y1maxk-cp2k)/dik+cpxk;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di2k=800.0+rand()/800.0;
                    ak=di2k;
                    bk=-di2k*xstk+y1mink;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=800.0+rand()/800.0;
                    ak=di3k;
                    bk=-di3k*xenk+y1maxk;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                }
              }
            }
          }
          else{
            di=1.0+rand()/1000.0;
            yst=di*(x1min-cpx)+cp2;
            yen=di*(x1max-cpx)+cp2;
            l=1;
            kx[l-1]=x1min;
            ky[l-1]=di*(kx[l-1]-cpx)+cp2;
            l++;
            kx[l-1]=x1max;
            ky[l-1]=di*(kx[l-1]-cpx)+cp2;
            a=di;
            b=-di*cpx+cp2;
            for(k=1;k<=N;k++){
              if(k!=i && k!=j){
                x1maxk=x1[i-1];
                x1mink=x1[k-1];
                if(x1[i-1]<x1[k-1]){
                  x1maxk=x1[k-1];
                  x1mink=x1[i-1];
                }
                y1maxk=y1[i-1];
                y1mink=y1[k-1];
                if(y1[i-1]<y1[k-1]){
                  y1maxk=y1[k-1];
                  y1mink=y1[i-1];
                }
                cp2k=(y1[i-1]+y1[k-1])/2.0;
                cpxk=(x1[i-1]+x1[k-1])/2.0;
                if(abso(x1[i-1]-x1[k-1])<abso(y1[i-1]-y1[k-1])){
                  if((x1[i-1]-x1[k-1])*(y1[i-1]-y1[k-1])>0){
                    dik=-1.0+rand()/1000.0;
                    ystk=dik*(x1mink-cpxk)+cp2k;
                    yenk=dik*(x1maxk-cpxk)+cp2k;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di2k=-rand()/800.0;
                    ak=di2k;
                    bk=-di2k*x1mink+ystk;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=-rand()/800.0;
                    ak=di3k;
                    bk=-di3k*x1maxk+yenk;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                  else{
                    dik=1.0+rand()/1000.0;
                    ystk=dik*(x1mink-cpxk)+cp2k;
                    yenk=dik*(x1maxk-cpxk)+cp2k;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    di2k=rand()/800.0;
                    ak=di2k;
                    bk=-di2k*x1mink+ystk;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=rand()/800.0;
                    ak=di3k;
                    bk=-di3k*x1maxk+yenk;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                }
                else{
                  if((x1[i-1]-x1[k-1])*(y1[i-1]-y1[k-1])>0){
                    dik=-1.0+rand()/1000.0;
                    xstk=(y1mink-cp2k)/dik+cpxk;
                    xenk=(y1maxk-cp2k)/dik+cpxk;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di2k=-800.0+rand()/800.0;
                    ak=di2k;
                    bk=-di2k*xstk+y1mink;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=-800.0+rand()/800.0;
                    ak=di3k;
                    bk=-di3k*xenk+y1maxk;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                  else{
                    dik=1.0+rand()/1000.0;
                    xstk=(y1mink-cp2k)/dik+cpxk;
                    xenk=(y1maxk-cp2k)/dik+cpxk;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    di2k=800.0+rand()/800.0;
                    ak=di2k;
                    bk=-di2k*xstk+y1mink;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=800.0+rand()/800.0;
                    ak=di3k;
                    bk=-di3k*xenk+y1maxk;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                }
              }
            }
            di2=rand()/800.0;
            l++;
            kx[l-1]=0.0;
            ky[l-1]=di2*(kx[l-1]-x1min)+yst;
            a=di2;
            b=-di2*x1min+yst;
            for(k=1;k<=N;k++){
              if(k!=i && k!=j){
                x1maxk=x1[i-1];
                x1mink=x1[k-1];
                if(x1[i-1]<x1[k-1]){
                  x1maxk=x1[k-1];
                  x1mink=x1[i-1];
                }
                y1maxk=y1[i-1];
                y1mink=y1[k-1];
                if(y1[i-1]<y1[k-1]){
                  y1maxk=y1[k-1];
                  y1mink=y1[i-1];
                }
                cp2k=(y1[i-1]+y1[k-1])/2.0;
                cpxk=(x1[i-1]+x1[k-1])/2.0;
                if(abso(x1[i-1]-x1[k-1])<abso(y1[i-1]-y1[k-1])){
                  if((x1[i-1]-x1[k-1])*(y1[i-1]-y1[k-1])>0){
                    dik=-1.0+rand()/1000.0;
                    ystk=dik*(x1mink-cpxk)+cp2k;
                    yenk=dik*(x1maxk-cpxk)+cp2k;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                  else{
                    dik=1.0+rand()/1000.0;
                    ystk=dik*(x1mink-cpxk)+cp2k;
                    yenk=dik*(x1maxk-cpxk)+cp2k;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                }
                else{
                  if((x1[i-1]-x1[k-1])*(y1[i-1]-y1[k-1])>0){
                    dik=-1.0+rand()/1000.0;
                    xstk=(y1mink-cp2k)/dik+cpxk;
                    xenk=(y1maxk-cp2k)/dik+cpxk;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di2k=-800.0+rand()/800.0;
                    ak=di2k;
                    bk=-di2k*xstk+y1mink;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=-800.0+rand()/800.0;
                    ak=di3k;
                    bk=-di3k*xenk+y1maxk;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                  else{
                    dik=1.0+rand()/1000.0;
                    xstk=(y1mink-cp2k)/dik+cpxk;
                    xenk=(y1maxk-cp2k)/dik+cpxk;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di2k=800.0+rand()/800.0;
                    ak=di2k;
                    bk=-di2k*xstk+y1mink;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=800.0+rand()/800.0;
                    ak=di3k;
                    bk=-di3k*xenk+y1maxk;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                }
              }
            }
            di3=rand()/800.0;
            l++;
            kx[l-1]=haba;
            ky[l-1]=di3*(kx[l-1]-x1max)+yen;
            a=di3;
            b=-di3*x1max+yen;
            for(k=1;k<=N;k++){
              if(k!=i && k!=j){
                x1maxk=x1[i-1];
                x1mink=x1[k-1];
                if(x1[i-1]<x1[k-1]){
                  x1maxk=x1[k-1];
                  x1mink=x1[i-1];
                }
                y1maxk=y1[i-1];
                y1mink=y1[k-1];
                if(y1[i-1]<y1[k-1]){
                  y1maxk=y1[k-1];
                  y1mink=y1[i-1];
                }
                cp2k=(y1[i-1]+y1[k-1])/2.0;
                cpxk=(x1[i-1]+x1[k-1])/2.0;
                if(abso(x1[i-1]-x1[k-1])<abso(y1[i-1]-y1[k-1])){
                  if((x1[i-1]-x1[k-1])*(y1[i-1]-y1[k-1])>0){
                    dik=-1.0+rand()/1000.0;
                    ystk=dik*(x1mink-cpxk)+cp2k;
                    yenk=dik*(x1maxk-cpxk)+cp2k;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                  else{
                    dik=1.0+rand()/1000.0;
                    ystk=dik*(x1mink-cpxk)+cp2k;
                    yenk=dik*(x1maxk-cpxk)+cp2k;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                }
                else{
                  if((x1[i-1]-x1[k-1])*(y1[i-1]-y1[k-1])>0){
                    dik=-1.0+rand()/1000.0;
                    xstk=(y1mink-cp2k)/dik+cpxk;
                    xenk=(y1maxk-cp2k)/dik+cpxk;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di2k=-800.0+rand()/800.0;
                    ak=di2k;
                    bk=-di2k*xstk+y1mink;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=-800.0+rand()/800.0;
                    ak=di3k;
                    bk=-di3k*xenk+y1maxk;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                  else{
                    dik=1.0+rand()/1000.0;
                    xstk=(y1mink-cp2k)/dik+cpxk;
                    xenk=(y1maxk-cp2k)/dik+cpxk;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di2k=800.0+rand()/800.0;
                    ak=di2k;
                    bk=-di2k*xstk+y1mink;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=800.0+rand()/800.0;
                    ak=di3k;
                    bk=-di3k*xenk+y1maxk;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                }
              }
            }
          }
          for(u=1;u<=l;u++){
            kz[u-1]=0;
          }
          heapv(kx,ky,kz,l);
          for(k=1;k<=l-1;k++){
            k2=k+1;
            xx=(kx[k-1]+kx[k2-1])/2.0;
            yy2=(ky[k-1]+ky[k2-1])/2.0;
            ds=dis(xx,yy2,x1[i-1],y1[i-1]);
            br2=0;
            for(u=1;u<=N;u++){
              if(u!=i && u!=j){
                us=dis(xx,yy2,x1[u-1],y1[u-1]);
                if(us<ds){
                  br2=br2+1;
                }
              }
            }
            if(br2==0){
              g.setColor(cl[0]);
              g.drawLine((int)kx[k-1],(int)ky[k-1],(int)kx[k2-1],(int)ky[k2-1]);
            }
          }

        }
        else{
          for(u=1;u<=N;u++){
            s[u-1]=x1[u-1];
            x1[u-1]=y1[u-1];
            y1[u-1]=s[u-1];
          }
          x1max=x1[i-1];
          x1min=x1[j-1];
          if(x1[i-1]<x1[j-1]){
            x1max=x1[j-1];
            x1min=x1[i-1];
          }
          y1max=y1[i-1];
          y1min=y1[j-1];
          if(y1[i-1]<y1[j-1]){
            y1max=y1[j-1];
            y1min=y1[i-1];
          }
          cp2=(y1[i-1]+y1[j-1])/2;
          cpx=(x1[i-1]+x1[j-1])/2;
          if((x1[i-1]-x1[j-1])*(y1[i-1]-y1[j-1])>0){
            di=-1.0+rand()/1000.0;
            yst=di*(x1min-cpx)+cp2;
            yen=di*(x1max-cpx)+cp2;
            l=1;
            kx[l-1]=x1min;
            ky[l-1]=di*(kx[l-1]-cpx)+cp2;
            l++;
            kx[l-1]=x1max;
            ky[l-1]=di*(kx[l-1]-cpx)+cp2;
            a=di;
            b=-di*cpx+cp2;
            for(k=1;k<=N;k++){
              if(k!=i && k!=j){
                x1maxk=x1[i-1];
                x1mink=x1[k-1];
                if(x1[i-1]<x1[k-1]){
                  x1maxk=x1[k-1];
                  x1mink=x1[i-1];
                }
                y1maxk=y1[i-1];
                y1mink=y1[k-1];
                if(y1[i-1]<y1[k-1]){
                  y1maxk=y1[k-1];
                  y1mink=y1[i-1];
                }
                cp2k=(y1[i-1]+y1[k-1])/2.0;
                cpxk=(x1[i-1]+x1[k-1])/2.0;
                if(abso(x1[i-1]-x1[k-1])<abso(y1[i-1]-y1[k-1])){
                  if((x1[i-1]-x1[k-1])*(y1[i-1]-y1[k-1])>0){
                    dik=-1.0+rand()/1000.0;
                    ystk=dik*(x1mink-cpxk)+cp2k;
                    yenk=dik*(x1maxk-cpxk)+cp2k;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    di2k=-rand()/800.0;
                    ak=di2k;
                    bk=-di2k*x1mink+ystk;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=-rand()/800.0;
                    ak=di3k;
                    bk=-di3k*x1maxk+yenk;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                  else{
                    dik=1.0+rand()/1000.0;
                    ystk=dik*(x1mink-cpxk)+cp2k;
                    yenk=dik*(x1maxk-cpxk)+cp2k;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di2k=rand()/800.0;
                    ak=di2k;
                    bk=-di2k*x1mink+ystk;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=rand()/800.0;
                    ak=di3k;
                    bk=-di3k*x1maxk+yenk;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                }
                else{
                  if((x1[i-1]-x1[k-1])*(y1[i-1]-y1[k-1])>0){
                    dik=-1.0+rand()/800.0;
                    xstk=(y1mink-cp2k)/dik+cpxk;
                    xenk=(y1maxk-cp2k)/dik+cpxk;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    di2k=-800.0+rand()/800.0;
                    ak=di2k;
                    bk=-di2k*xstk+y1mink;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=-800.0+rand()/800.0;
                    ak=di3k;
                    bk=-di3k*xenk+y1maxk;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                  else{
                    dik=1.0+rand()/1000.0;
                    xstk=(y1mink-cp2k)/dik+cpxk;
                    xenk=(y1maxk-cp2k)/dik+cpxk;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di2k=800.0+rand()/800.0;
                    ak=di2k;
                    bk=-di2k*xstk+y1mink;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=800.0+rand()/800.0;
                    ak=di3k;
                    bk=-di3k*xenk+y1maxk;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                }
              }
            }
            di2=-rand()/800.0;
            yst2=di2*(0.0-x1min)+yst;
            yen2=di2*(x1min-x1min)+yst;
            l++;
            kx[l-1]=0.0;
            ky[l-1]=di2*(kx[l-1]-x1min)+yst;
            a=di2;
            b=-di2*x1min+yst;
            for(k=1;k<=N;k++){
              if(k!=i && k!=j){
                x1maxk=x1[i-1];
                x1mink=x1[k-1];
                if(x1[i-1]<x1[k-1]){
                  x1maxk=x1[k-1];
                  x1mink=x1[i-1];
                }
                y1maxk=y1[i-1];
                y1mink=y1[k-1];
                if(y1[i-1]<y1[k-1]){
                  y1maxk=y1[k-1];
                  y1mink=y1[i-1];
                }
                cp2k=(y1[i-1]+y1[k-1])/2.0;
                cpxk=(x1[i-1]+x1[k-1])/2.0;
                if(abso(x1[i-1]-x1[k-1])<abso(y1[i-1]-y1[k-1])){
                  if((x1[i-1]-x1[k-1])*(y1[i-1]-y1[k-1])>0){
                    dik=-1.0+rand()/1000.0;
                    ystk=dik*(x1mink-cpxk)+cp2k;
                    yenk=dik*(x1maxk-cpxk)+cp2k;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                  else{
                    dik=1.0+rand()/1000.0;
                    ystk=dik*(x1mink-cpxk)+cp2k;
                    yenk=dik*(x1maxk-cpxk)+cp2k;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                }
                else{
                  if((x1[i-1]-x1[k-1])*(y1[i-1]-y1[k-1])>0){
                    dik=-1.0+rand()/1000.0;
                    xstk=(y1mink-cp2k)/dik+cpxk;
                    xenk=(y1maxk-cp2k)/dik+cpxk;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di2k=-800.0+rand()/800.0;
                    ak=di2k;
                    bk=-di2k*xstk+y1mink;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=-800.0+rand()/800.0;
                    ak=di3k;
                    bk=-di3k*xenk+y1maxk;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                  else{
                    dik=1.0+rand()/1000.0;
                    xstk=(y1mink-cp2k)/dik+cpxk;
                    xenk=(y1maxk-cp2k)/dik+cpxk;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di2k=800.0+rand()/800.0;
                    ak=di2k;
                    bk=-di2k*xstk+y1mink;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=800.0+rand()/800.0;
                    ak=di3k;
                    bk=-di3k*xenk+y1maxk;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                }
              }
            }

            di3=-rand()/800.0;
            yst3=di3*(x1max-x1max)+yen;
            yen3=di3*(haba-x1max)+yen;
            l++;
            kx[l-1]=haba;
            ky[l-1]=di3*(kx[l-1]-x1max)+yen;
            a=di3;
            b=-di3*x1max+yen;
            for(k=1;k<=N;k++){
              if(k!=i && k!=j){
                x1maxk=x1[i-1];
                x1mink=x1[k-1];
                if(x1[i-1]<x1[k-1]){
                  x1maxk=x1[k-1];
                  x1mink=x1[i-1];
                }
                y1maxk=y1[i-1];
                y1mink=y1[k-1];
                if(y1[i-1]<y1[k-1]){
                  y1maxk=y1[k-1];
                  y1mink=y1[i-1];
                }
                cp2k=(y1[i-1]+y1[k-1])/2.0;
                cpxk=(x1[i-1]+x1[k-1])/2.0;
                if(abso(x1[i-1]-x1[k-1])<abso(y1[i-1]-y1[k-1])){
                  if((x1[i-1]-x1[k-1])*(y1[i-1]-y1[k-1])>0){
                    dik=-1.0+rand()/1000.0;
                    ystk=dik*(x1mink-cpxk)+cp2k;
                    yenk=dik*(x1maxk-cpxk)+cp2k;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                  else{
                    dik=1.0+rand()/1000.0;
                    ystk=dik*(x1mink-cpxk)+cp2k;
                    yenk=dik*(x1maxk-cpxk)+cp2k;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                }
                else{
                  if((x1[i-1]-x1[k-1])*(y1[i-1]-y1[k-1])>0){
                    dik=-1.0+rand()/1000.0;
                    xstk=(y1mink-cp2k)/dik+cpxk;
                    xenk=(y1maxk-cp2k)/dik+cpxk;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di2k=-800.0+rand()/800.0;
                    ak=di2k;
                    bk=-di2k*xstk+y1mink;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=-800.0+rand()/800.0;
                    ak=di3k;
                    bk=-di3k*xenk+y1maxk;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                  else{
                    dik=1.0+rand()/1000.0;
                    xstk=(y1mink-cp2k)/dik+cpxk;
                    xenk=(y1maxk-cp2k)/dik+cpxk;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di2k=800.0+rand()/800.0;
                    ak=di2k;
                    bk=-di2k*xstk+y1mink;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=800.0+rand()/800.0;
                    ak=di3k;
                    bk=-di3k*xenk+y1maxk;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                }
              }
            }
          }
          else{
            di=1.0+rand()/1000.0;
            yst=di*(x1min-cpx)+cp2;
            yen=di*(x1max-cpx)+cp2;
            l=1;
            kx[l-1]=x1min;
            ky[l-1]=di*(kx[l-1]-cpx)+cp2;
            l++;
            kx[l-1]=x1max;
            ky[l-1]=di*(kx[l-1]-cpx)+cp2;
            a=di;
            b=-di*cpx+cp2;
            for(k=1;k<=N;k++){
              if(k!=i && k!=j){
                x1maxk=x1[i-1];
                x1mink=x1[k-1];
                if(x1[i-1]<x1[k-1]){
                  x1maxk=x1[k-1];
                  x1mink=x1[i-1];
                }
                y1maxk=y1[i-1];
                y1mink=y1[k-1];
                if(y1[i-1]<y1[k-1]){
                  y1maxk=y1[k-1];
                  y1mink=y1[i-1];
                }
                cp2k=(y1[i-1]+y1[k-1])/2.0;
                cpxk=(x1[i-1]+x1[k-1])/2.0;
                if(abso(x1[i-1]-x1[k-1])<abso(y1[i-1]-y1[k-1])){
                  if((x1[i-1]-x1[k-1])*(y1[i-1]-y1[k-1])>0){
                    dik=-1.0+rand()/1000.0;
                    ystk=dik*(x1mink-cpxk)+cp2k;
                    yenk=dik*(x1maxk-cpxk)+cp2k;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di2k=-rand()/800.0;
                    ak=di2k;
                    bk=-di2k*x1mink+ystk;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=-rand()/800.0;
                    ak=di3k;
                    bk=-di3k*x1maxk+yenk;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                  else{
                    dik=1.0+rand()/1000.0;
                    ystk=dik*(x1mink-cpxk)+cp2k;
                    yenk=dik*(x1maxk-cpxk)+cp2k;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    di2k=rand()/800.0;
                    ak=di2k;
                    bk=-di2k*x1mink+ystk;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=rand()/800.0;
                    ak=di3k;
                    bk=-di3k*x1maxk+yenk;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                }
                else{
                  if((x1[i-1]-x1[k-1])*(y1[i-1]-y1[k-1])>0){
                    dik=-1.0+rand()/1000.0;
                    xstk=(y1mink-cp2k)/dik+cpxk;
                    xenk=(y1maxk-cp2k)/dik+cpxk;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di2k=-800.0+rand()/800.0;
                    ak=di2k;
                    bk=-di2k*xstk+y1mink;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=-800.0+rand()/800.0;
                    ak=di3k;
                    bk=-di3k*xenk+y1maxk;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                  else{
                    dik=1.0+rand()/1000.0;
                    xstk=(y1mink-cp2k)/dik+cpxk;
                    xenk=(y1maxk-cp2k)/dik+cpxk;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    di2k=800.0+rand()/800.0;
                    ak=di2k;
                    bk=-di2k*xstk+y1mink;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=800.0+rand()/800.0;
                    ak=di3k;
                    bk=-di3k*xenk+y1maxk;
                    if(koutenx(a,b,ak,bk)>x1min && koutenx(a,b,ak,bk)<x1max){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                }
              }
            }
            di2=rand()/800.0;
            l++;
            kx[l-1]=0.0;
            ky[l-1]=di2*(kx[l-1]-x1min)+yst;
            a=di2;
            b=-di2*x1min+yst;
            for(k=1;k<=N;k++){
              if(k!=i && k!=j){
                x1maxk=x1[i-1];
                x1mink=x1[k-1];
                if(x1[i-1]<x1[k-1]){
                  x1maxk=x1[k-1];
                  x1mink=x1[i-1];
                }
                y1maxk=y1[i-1];
                y1mink=y1[k-1];
                if(y1[i-1]<y1[k-1]){
                  y1maxk=y1[k-1];
                  y1mink=y1[i-1];
                }
                cp2k=(y1[i-1]+y1[k-1])/2.0;
                cpxk=(x1[i-1]+x1[k-1])/2.0;
                if(abso(x1[i-1]-x1[k-1])<abso(y1[i-1]-y1[k-1])){
                  if((x1[i-1]-x1[k-1])*(y1[i-1]-y1[k-1])>0){
                    dik=-1.0+rand()/1000.0;
                    ystk=dik*(x1mink-cpxk)+cp2k;
                    yenk=dik*(x1maxk-cpxk)+cp2k;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                  else{
                    dik=1.0+rand()/1000.0;
                    ystk=dik*(x1mink-cpxk)+cp2k;
                    yenk=dik*(x1maxk-cpxk)+cp2k;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                }
                else{
                  if((x1[i-1]-x1[k-1])*(y1[i-1]-y1[k-1])>0){
                    dik=-1.0+rand()/1000.0;
                    xstk=(y1mink-cp2k)/dik+cpxk;
                    xenk=(y1maxk-cp2k)/dik+cpxk;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di2k=-800.0+rand()/800.0;
                    ak=di2k;
                    bk=-di2k*xstk+y1mink;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=-800.0+rand()/800.0;
                    ak=di3k;
                    bk=-di3k*xenk+y1maxk;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                  else{
                    dik=1.0+rand()/1000.0;
                    xstk=(y1mink-cp2k)/dik+cpxk;
                    xenk=(y1maxk-cp2k)/dik+cpxk;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di2k=800.0+rand()/800.0;
                    ak=di2k;
                    bk=-di2k*xstk+y1mink;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=800.0+rand()/800.0;
                    ak=di3k;
                    bk=-di3k*xenk+y1maxk;
                    if(koutenx(a,b,ak,bk)>0 && koutenx(a,b,ak,bk)<x1min){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                }
              }
            }
            di3=rand()/800.0;
            l++;
            kx[l-1]=haba;
            ky[l-1]=di3*(kx[l-1]-x1max)+yen;
            a=di3;
            b=-di3*x1max+yen;
            for(k=1;k<=N;k++){
              if(k!=i && k!=j){
                x1maxk=x1[i-1];
                x1mink=x1[k-1];
                if(x1[i-1]<x1[k-1]){
                  x1maxk=x1[k-1];
                  x1mink=x1[i-1];
                }
                y1maxk=y1[i-1];
                y1mink=y1[k-1];
                if(y1[i-1]<y1[k-1]){
                  y1maxk=y1[k-1];
                  y1mink=y1[i-1];
                }
                cp2k=(y1[i-1]+y1[k-1])/2.0;
                cpxk=(x1[i-1]+x1[k-1])/2.0;
                if(abso(x1[i-1]-x1[k-1])<abso(y1[i-1]-y1[k-1])){
                  if((x1[i-1]-x1[k-1])*(y1[i-1]-y1[k-1])>0){
                    dik=-1.0+rand()/1000.0;
                    ystk=dik*(x1mink-cpxk)+cp2k;
                    yenk=dik*(x1maxk-cpxk)+cp2k;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                  else{
                    dik=1.0+rand()/1000.0;
                    ystk=dik*(x1mink-cpxk)+cp2k;
                    yenk=dik*(x1maxk-cpxk)+cp2k;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                }
                else{
                  if((x1[i-1]-x1[k-1])*(y1[i-1]-y1[k-1])>0){
                    dik=-1.0+rand()/1000.0;
                    xstk=(y1mink-cp2k)/dik+cpxk;
                    xenk=(y1maxk-cp2k)/dik+cpxk;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di2k=-800.0+rand()/800.0;
                    ak=di2k;
                    bk=-di2k*xstk+y1mink;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=-800.0+rand()/800.0;
                    ak=di3k;
                    bk=-di3k*xenk+y1maxk;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                  else{
                    dik=1.0+rand()/1000.0;
                    xstk=(y1mink-cp2k)/dik+cpxk;
                    xenk=(y1maxk-cp2k)/dik+cpxk;
                    ak=dik;
                    bk=-dik*cpxk+cp2k;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di2k=800.0+rand()/800.0;
                    ak=di2k;
                    bk=-di2k*xstk+y1mink;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                    di3k=800.0+rand()/800.0;
                    ak=di3k;
                    bk=-di3k*xenk+y1maxk;
                    if(koutenx(a,b,ak,bk)>x1max && koutenx(a,b,ak,bk)<haba){
                      l++;
                      kx[l-1]=koutenx(a,b,ak,bk);
                      ky[l-1]=kouteny(a,b,ak,bk);
                    }
                  }
                }
              }
            }
          }
          for(u=1;u<=l;u++){
            kz[u-1]=0;
          }
          heapv(kx,ky,kz,l);

          for(k=1;k<=l-1;k++){
            k2=k+1;
            xx=(kx[k-1]+kx[k2-1])/2.0;
            yy2=(ky[k-1]+ky[k2-1])/2.0;
            ds=dis(xx,yy2,x1[i-1],y1[i-1]);
            br2=0;
            for(u=1;u<=N;u++){
              if(u!=i && u!=j){
                us=dis(xx,yy2,x1[u-1],y1[u-1]);
                if(us<ds){
                  br2=br2+1;
                }
              }
            }
            if(br2==0){
              g.setColor(cl[0]);
              g.drawLine((int)ky[k-1],(int)kx[k-1],(int)ky[k2-1],(int)kx[k2-1]);
            }
          }
          for(u=1;u<=N;u++){
            s[u-1]=x1[u-1];
            x1[u-1]=y1[u-1];
            y1[u-1]=s[u-1];
          }

          for(u=1;u<=l;u++){
            s[u-1]=kx[u-1];
            kx[u-1]=ky[u-1];
            ky[u-1]=s[u-1];
          }
        }





      }
    }
    g.setColor(col2);
    g.drawString("N="+N,15,15);

  }
    
}