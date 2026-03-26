import java.util.Arrays;

public class TSPBruteForce {
    static int minimumJarak = Integer.MAX_VALUE;
    static int[] ruteTerbaik;
    public static void main(String[] args) {
        int[][] distances = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        int n = distances.length;
        int[] kotaTersisa = new int[n - 1];
        for(int i = 0; i < n - 1; i++) {
            kotaTersisa[i] = i + 1;
        }

        ruteTerbaik = new int[n - 1];
        cariPermutasi(kotaTersisa, 0, n - 2, distances);

        System.out.println("=== Hasil TSP dengan Brute Force ===");
        System.out.print("Rute Terbaik  : 0 -> ");
        for(int kota : ruteTerbaik) {
            System.out.print(kota + " -> ");
        }
        System.out.println("0");
        System.out.println("Minimum Jarak : " + minimumJarak);
    }

    static void cariPermutasi(int[] A, int l, int r, int[][] D) {
        if(l == r) {
            int jarakSaatIni = 0;
            int kotaSebelumnya = 0;
            for(int k : A) {
                jarakSaatIni += D[kotaSebelumnya][k];
                kotaSebelumnya = k;
            }
            
            jarakSaatIni += D[kotaSebelumnya][0];

            if(jarakSaatIni < minimumJarak) {
                minimumJarak = jarakSaatIni;
                ruteTerbaik = A.clone(); 
            }
        } 
        else {
            for(int i = l; i <= r; i++) {
                tukar(A, l, i);
                cariPermutasi(A, l + 1, r, D);
                tukar(A, l, i); 
            }
        }
    }

    static void tukar(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

// Muhammad Fakhri Aldiansyah
// 245150201111049
// DAA TIF C