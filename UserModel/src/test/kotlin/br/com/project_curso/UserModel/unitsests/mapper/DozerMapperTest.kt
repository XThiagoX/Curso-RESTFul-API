package br.com.erudio.unittests.mapper

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import br.com.erudio.unittests.mapper.mocks.MockUser
import br.com.project_curso.UserModel.data.vo.v1.UserVO
import br.com.project_curso.UserModel.mapper.DozerMapper
import br.com.project_curso.UserModel.model.User

class DozerMapperTest {

    var inputObject: MockUser? = null

    @BeforeEach
    fun setUp() {
        inputObject = MockUser()
    }

    @Test
    fun parseEntityToVOTest() {
        val output: UserVO = DozerMapper.parseObject(inputObject!!.mockEntity(), UserVO::class.java)
        assertEquals(0, output.id)
        assertEquals("First Name Test0", output.firstName)
        assertEquals("Last Name Test0", output.lastName)
        assertEquals("Address Test0", output.address)
        assertEquals("Male", output.gender)
    }

    @Test
    fun parseEntityListToVOListTest() {
        val outputList: ArrayList<UserVO> =
            DozerMapper.parseListObject(inputObject!!.mockEntityList(), UserVO::class.java)

        val outputZero: UserVO = outputList[0]

        assertEquals(0, outputZero.id)
        assertEquals("First Name Test0", outputZero.firstName)
        assertEquals("Last Name Test0", outputZero.lastName)
        assertEquals("Address Test0", outputZero.address)
        assertEquals("Male", outputZero.gender)

        val outputSeven: UserVO = outputList[7]
        assertEquals(7.toLong(), outputSeven.id)
        assertEquals("First Name Test7", outputSeven.firstName)
        assertEquals("Last Name Test7", outputSeven.lastName)
        assertEquals("Address Test7", outputSeven.address)
        assertEquals("Female", outputSeven.gender)

        val outputTwelve: UserVO = outputList[12]
        assertEquals(12.toLong(), outputTwelve.id)
        assertEquals("First Name Test12", outputTwelve.firstName)
        assertEquals("Last Name Test12", outputTwelve.lastName)
        assertEquals("Address Test12", outputTwelve.address)
        assertEquals("Male", outputTwelve.gender)
    }

    @Test
    fun parseVOToEntityTest() {

        val output: User = DozerMapper.parseObject(inputObject!!.mockVO(), User::class.java)

        assertEquals(0, output.id)
        assertEquals("First Name Test0", output.firstName)
        assertEquals("Last Name Test0", output.lastName)
        assertEquals("Address Test0", output.address)
        assertEquals("Male", output.gender)
    }

    @Test
    fun parserVOListToEntityListTest() {

        val outputList: ArrayList<User> = DozerMapper.parseListObject(inputObject!!.mockVOList(), User::class.java)

        val outputZero: User = outputList[0]
        assertEquals(0, outputZero.id)
        assertEquals("First Name Test0", outputZero.firstName)
        assertEquals("Last Name Test0", outputZero.lastName)
        assertEquals("Address Test0", outputZero.address)
        assertEquals("Male", outputZero.gender)

        val outputSeven: User = outputList[7]
        assertEquals(7, outputSeven.id)
        assertEquals("First Name Test7", outputSeven.firstName)
        assertEquals("Last Name Test7", outputSeven.lastName)
        assertEquals("Address Test7", outputSeven.address)
        assertEquals("Female", outputSeven.gender)

        val outputTwelve: User = outputList[12]
        assertEquals(12, outputTwelve.id)
        assertEquals("First Name Test12", outputTwelve.firstName)
        assertEquals("Last Name Test12", outputTwelve.lastName)
        assertEquals("Address Test12", outputTwelve.address)
        assertEquals("Male", outputTwelve.gender)
    }
}