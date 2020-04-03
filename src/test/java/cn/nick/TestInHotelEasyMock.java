package cn.nick;

import org.easymock.EasyMock;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestInHotelEasyMock {
    private IData iData = null;

    @Test
    public void testInSucess(){
        iData = EasyMock.createMock(IData.class);
        EasyMock.expect(iData.in_Out_Room(101,"张三")).andReturn("张三成功入住101房间！");
        EasyMock.replay(iData);

        InHotel inHotel = new InHotel(iData);
        String result = inHotel.in(101,"张三");
        assertEquals("张三成功入住101房间！",result);
    }

    @Test
    public void testInFailure(){
        iData = EasyMock.createMock(IData.class);
        EasyMock.expect(iData.in_Out_Room(101,"张三")).andReturn("该房间已经有客人入住！");
        EasyMock.replay(iData);

        InHotel inHotel = new InHotel(iData);
        String result = inHotel.in(101,"张三");
        assertEquals("该房间已经有客人入住！",result);
    }
}
