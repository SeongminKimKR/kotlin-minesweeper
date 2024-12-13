package minesweeper.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import minesweeper.config.BoardSize
import minesweeper.config.MinesWeeperSetting

class MinesTest : BehaviorSpec({
    Given("지뢰들은") {
        When("지뢰 리스트를") {
            val mineList =
                listOf(
                    Point(1, 0),
                    Point(2, 0),
                    Point(3, 0),
                )
            Then("생성 후 프로퍼티로 갖는다.") {
                val size =
                    BoardSize(
                        Height(1),
                        Width(1),
                    )

                val setting =
                    MinesWeeperSetting(
                        size,
                        MineCount(1),
                    )
                val mines = Mines(FakeMineGenerator(mineList), setting)
                mines.elements.size shouldBe mineList.size
            }
        }
    }
})
