package htht.system.ocean.core;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static Result genSuccessResult(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }
    public static Result genParameterFailResult() {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage("请求失败");
    }
    public static Result genExsitFailResult() {
        return new Result()
                .setCode(ResultCode.FILEEXIT)
                .setMessage("文件名存在重名");
    }
}
