package com.doit.peakge.hos.core;

public interface ErrorCode {
    public static final int ERROR_PERMISSION_DENIED=403;//
    public static final int ERROR_FILE_NOT_FOUND = 404;//hos中没有找到文件
    public static final int ERROR_HBASE = 500;//Hbase集群出现问题
    public static final int ERROR_HDFS = 501;//HDFS集群出现问题
}
