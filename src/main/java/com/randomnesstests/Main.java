package com.randomnesstests;

import com.randomnesstests.Tests.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Boolean> B2bit(byte b) {
        ArrayList<Boolean> arr = new ArrayList<>(8);
        arr.add((b & 0x80) > 0);
        arr.add((b & 0x40) > 0);
        arr.add((b & 0x20) > 0);
        arr.add((b & 0x10) > 0);

        arr.add((b & 0x08) > 0);
        arr.add((b & 0x04) > 0);
        arr.add((b & 0x02) > 0);
        arr.add((b & 0x01) > 0);
        return arr;
    }

    public static void main(String[] args) throws IOException {

        List<Boolean> bits = new ArrayList<>(1500000);
//        for (int i = 0; i < 1000000; i++) {
//            if (Math.random() < 0.5) {
//                bits.add(true);
//
//            } else {
//                bits.add(false);
//
//            }
//        }

        final byte[] bytes = Files.readAllBytes(Paths.get("data.bin"));
        for (byte aByte : bytes) {
            bits.addAll(B2bit(aByte));
        }


//          System.out.printf("%.6f\n",MonobitFrequencyTest.run(bits));
        System.out.printf("%.6f\n", FrequencyTestWithinABlock.run(bits));
        System.out.printf("%.6f\n", PokerTest.run(bits));
//          System.out.printf("%.6f\n",SerialTest.run(bits));
//          System.out.printf("%.6f\n",SerialTest.run2(bits));
//          System.out.printf("%.6f\n",RunsTest.run(bits)); // 分布相关，概率无关
//          System.out.printf("%.6f\n",RunsDistributionTest.run(bits));
//          System.out.printf("%.6f\n",testForTheLongestRunOfOnesInABlock.run(bits));
//          System.out.printf("%.6f\n",BinaryDerivativeTest.run(bits));// 分布相关，概率无关
//          System.out.printf("%.6f\n",AutocorrelationTest.run(bits));
//          System.out.printf("%.6f\n",BinaryMatrixRankTest.run(bits));// 分布强相关，概率弱相关
//          System.out.printf("%.6f\n",CumulativeTest.run(bits));
//          System.out.printf("%.6f\n",ApproximateEntropyTest.run(bits));
//          System.out.printf("%.6f\n",LinearComplexityTest.run(bits));// 分布相关，概率无关
//          System.out.printf("%.6f\n",MaurersUniversalTest.run(bits));
//          System.out.printf("%.6f\n",DiscreteFourierTransformTest.run(bits));
    }
}
