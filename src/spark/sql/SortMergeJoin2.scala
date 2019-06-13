/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator smj_leftInput;
/* 009 */   private scala.collection.Iterator smj_rightInput;
/* 010 */   private InternalRow smj_leftRow;
/* 011 */   private InternalRow smj_rightRow;
/* 012 */   private int smj_value2;
/* 013 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 014 */   private int smj_value3;
/* 015 */   private int smj_value4;
/* 016 */   private int smj_value5;
/* 017 */   private int smj_value6;
/* 018 */   private int smj_value7;
/* 019 */   private int smj_value8;
/* 020 */   private Decimal smj_value9;
/* 021 */   private Decimal smj_value10;
/* 022 */   private Decimal smj_value11;
/* 023 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 024 */   private UnsafeRow smj_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 027 */
/* 028 */   public GeneratedIterator(Object[] references) {
/* 029 */     this.references = references;
/* 030 */   }
/* 031 */
/* 032 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 033 */     partitionIndex = index;
/* 034 */     this.inputs = inputs;
/* 035 */     smj_leftInput = inputs[0];
/* 036 */     smj_rightInput = inputs[1];
/* 037 */
/* 038 */     smj_rightRow = null;
/* 039 */
/* 040 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 041 */
/* 042 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 043 */     smj_result = new UnsafeRow(10);
/* 044 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 32);
/* 045 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 10);
/* 046 */
/* 047 */   }
/* 048 */
/* 049 */   private boolean findNextInnerJoinRows(
/* 050 */     scala.collection.Iterator leftIter,
/* 051 */     scala.collection.Iterator rightIter) {
/* 052 */     smj_leftRow = null;
/* 053 */     int comp = 0;
/* 054 */     while (smj_leftRow == null) {
/* 055 */       if (!leftIter.hasNext()) return false;
/* 056 */       smj_leftRow = (InternalRow) leftIter.next();
/* 057 */
/* 058 */       int smj_value = smj_leftRow.getInt(2);
/* 059 */       if (false) {
/* 060 */         smj_leftRow = null;
/* 061 */         continue;
/* 062 */       }
/* 063 */       if (!smj_matches.isEmpty()) {
/* 064 */         comp = 0;
/* 065 */         if (comp == 0) {
/* 066 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 067 */         }
/* 068 */
/* 069 */         if (comp == 0) {
/* 070 */           return true;
/* 071 */         }
/* 072 */         smj_matches.clear();
/* 073 */       }
/* 074 */
/* 075 */       do {
/* 076 */         if (smj_rightRow == null) {
/* 077 */           if (!rightIter.hasNext()) {
/* 078 */             smj_value3 = smj_value;
/* 079 */             return !smj_matches.isEmpty();
/* 080 */           }
/* 081 */           smj_rightRow = (InternalRow) rightIter.next();
/* 082 */
/* 083 */           int smj_value1 = smj_rightRow.getInt(0);
/* 084 */           if (false) {
/* 085 */             smj_rightRow = null;
/* 086 */             continue;
/* 087 */           }
/* 088 */           smj_value2 = smj_value1;
/* 089 */         }
/* 090 */
/* 091 */         comp = 0;
/* 092 */         if (comp == 0) {
/* 093 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 094 */         }
/* 095 */
/* 096 */         if (comp > 0) {
/* 097 */           smj_rightRow = null;
/* 098 */         } else if (comp < 0) {
/* 099 */           if (!smj_matches.isEmpty()) {
/* 100 */             smj_value3 = smj_value;
/* 101 */             return true;
/* 102 */           }
/* 103 */           smj_leftRow = null;
/* 104 */         } else {
/* 105 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 106 */           smj_rightRow = null;;
/* 107 */         }
/* 108 */       } while (smj_leftRow != null);
/* 109 */     }
/* 110 */     return false; // unreachable
/* 111 */   }
/* 112 */
/* 113 */   protected void processNext() throws java.io.IOException {
/* 114 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 115 */       smj_value4 = smj_leftRow.getInt(0);
/* 116 */       smj_value5 = smj_leftRow.getInt(1);
/* 117 */       smj_value6 = smj_leftRow.getInt(2);
/* 118 */       smj_value7 = smj_leftRow.getInt(3);
/* 119 */       smj_value8 = smj_leftRow.getInt(4);
/* 120 */       smj_value9 = smj_leftRow.getDecimal(5, 10, 4);
/* 121 */       smj_value10 = smj_leftRow.getDecimal(6, 10, 4);
/* 122 */       smj_value11 = smj_leftRow.getDecimal(7, 10, 4);
/* 123 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 124 */       while (smj_iterator.hasNext()) {
/* 125 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 126 */
/* 127 */         smj_numOutputRows.add(1);
/* 128 */
/* 129 */         int smj_value12 = smj_rightRow1.getInt(0);
/* 130 */         UTF8String smj_value13 = smj_rightRow1.getUTF8String(1);
/* 131 */         smj_holder.reset();
/* 132 */
/* 133 */         smj_rowWriter.write(0, smj_value4);
/* 134 */
/* 135 */         smj_rowWriter.write(1, smj_value5);
/* 136 */
/* 137 */         smj_rowWriter.write(2, smj_value6);
/* 138 */
/* 139 */         smj_rowWriter.write(3, smj_value7);
/* 140 */
/* 141 */         smj_rowWriter.write(4, smj_value8);
/* 142 */
/* 143 */         smj_rowWriter.write(5, smj_value9, 10, 4);
/* 144 */
/* 145 */         smj_rowWriter.write(6, smj_value10, 10, 4);
/* 146 */
/* 147 */         smj_rowWriter.write(7, smj_value11, 10, 4);
/* 148 */
/* 149 */         smj_rowWriter.write(8, smj_value12);
/* 150 */
/* 151 */         smj_rowWriter.write(9, smj_value13);
/* 152 */         smj_result.setTotalSize(smj_holder.totalSize());
/* 153 */         append(smj_result.copy());
/* 154 */
/* 155 */       }
/* 156 */       if (shouldStop()) return;
/* 157 */     }
/* 158 */   }
/* 159 */ }
